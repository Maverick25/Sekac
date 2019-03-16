package agency.alterway.sekac.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import agency.alterway.sekac.R;
import agency.alterway.sekac.controllers.FileController;
import agency.alterway.sekac.db.DatabaseManager;
import agency.alterway.sekac.injections.Injection;
import agency.alterway.sekac.models.Cut;
import agency.alterway.sekac.models.Summary;
import agency.alterway.sekac.utils.DateHandler;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SummaryActivity extends AppCompatActivity implements Injection {
    @BindView(R.id.button_dateChange)
    Button dateChangeButton;
    @BindView(R.id.text_totalCount)
    TextView totalCountLabel;
    @BindView(R.id.text_totalMatter)
    TextView totalMatterLabel;
    @BindView(R.id.text_totalVolume)
    TextView totalVolumeLabel;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);

        try {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        Summary summary = DatabaseManager.getInstance(this).getDaySummary();

        dateChangeButton.setText(DateHandler.formatter.format(new Date()));
        totalCountLabel.setText(summary.getFormattedNoOfCuts());
        totalMatterLabel.setText(summary.getFormattedMatter());
        totalVolumeLabel.setText(summary.getFormattedVolume());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == getResources().getInteger(R.integer.calendar_request_code)) {
            String dateString = data.getStringExtra(getString(R.string.key_current_date));

            dateChangeButton.setText(dateString);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }

    private void showProgress() {
        // Show modal progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.saving_progress_title));
        progressDialog.setMessage(getString(R.string.saving_progress_message));
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    private void showFinishDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(R.string.sure_to_finish_day)
                .setCancelable(true)
                .setPositiveButton(R.string.finish_day, (dialog12, which) -> {
                    dialog12.dismiss();

                    showProgress();

                    shareProgress(true);
                })
                .setNegativeButton(R.string.cancel, (dialog1, which) -> dialog1.dismiss())
                .create();

        dialog.show();
    }

    private void showNewDayDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(R.string.hooray_to_a_new_day)
                .setCancelable(true)
                .setNeutralButton(R.string.das_ist_hruza, (dialog1, which) -> onBackPressed())
                .create();

        dialog.show();
    }

    private void shareProgress(boolean isFinishingDay) {
        List<Cut> treeCuts = DatabaseManager.getInstance(this).getTreeCuts();
        Summary summary = DatabaseManager.getInstance(this).getDaySummary();

        try {
            Date selectedDate = DateHandler.formatter.parse(dateChangeButton.getText().toString());
            FileController.getInstance(this).exportToDisk(isFinishingDay, selectedDate, treeCuts, summary);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.button_shareProgress)
    void onSharedProgress() {
        showProgress();

        shareProgress(false);
    }

    @OnClick(R.id.button_finishDay)
    void onFinishedDay() {
        showFinishDialog();
    }

    @OnClick(R.id.button_dateChange)
    void onChangeDate(Button button) {
        Intent goToDatePicker = new Intent(this, CalendarActivity.class);
        goToDatePicker.putExtra(getString(R.string.key_current_date), button.getText());
        startActivityForResult(goToDatePicker, getResources().getInteger(R.integer.calendar_request_code));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @Override
    public void onUploadedSheet(boolean success, String message, boolean isFinishingDay) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        if (success) {
            if (isFinishingDay && DatabaseManager.getInstance(this).removeAllCuts()) {
                showNewDayDialog();
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

}
