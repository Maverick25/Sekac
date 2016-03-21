package agency.alterway.sekac.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SummaryActivity extends AppCompatActivity implements Injection
{
    @Bind(R.id.button_dateChange)
    Button   dateChangeButton;
    @Bind(R.id.text_totalCount)
    TextView totalCountLabel;
    @Bind(R.id.text_totalMatter)
    TextView totalMatterLabel;
    @Bind(R.id.text_totalVolume)
    TextView totalVolumeLabel;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);

        try
        {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        Summary summary = DatabaseManager.getInstance(this).getDaySummary();

        dateChangeButton.setText(DateHandler.formatter.format(new Date()));
        totalCountLabel.setText(summary.getFormattedNoOfCuts());
        totalMatterLabel.setText(summary.getFormattedMatter());
        totalVolumeLabel.setText(summary.getFormattedVolume());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK && requestCode == getResources().getInteger(R.integer.calendar_request_code))
        {
            String dateString = data.getStringExtra(getString(R.string.key_current_date));

            dateChangeButton.setText(dateString);
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }

    private void showProgress()
    {
        // Show modal progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.saving_progress_title));
        progressDialog.setMessage(getString(R.string.saving_progress_message));
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @OnClick(R.id.button_shareProgress)
    void onSharedProgress()
    {
        showProgress();

        List<Cut> treeCuts = DatabaseManager.getInstance(this).getTreeCuts();
        Summary summary = DatabaseManager.getInstance(this).getDaySummary();

        try
        {
            Date selectedDate = DateHandler.formatter.parse(dateChangeButton.getText().toString());
            FileController.getInstance(this).exportToCSV(selectedDate,treeCuts, summary);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.button_finishDay)
    void onFinishedDay()
    {

    }

    @OnClick(R.id.button_dateChange)
    void onChangeDate(Button button)
    {
        Intent goToDatePicker = new Intent(this, CalendarActivity.class);
        goToDatePicker.putExtra(getString(R.string.key_current_date), button.getText());
        startActivityForResult(goToDatePicker, getResources().getInteger(R.integer.calendar_request_code));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @Override
    public void onUploadedSheet(String message)
    {
        if(progressDialog!= null && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
