package agency.alterway.sekac.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                return true;
            default:
                return false;
        }
    }

    @OnClick(R.id.button_shareProgress)
    void onSharedProgress()
    {
        List<Cut> treeCuts = DatabaseManager.getInstance(this).getTreeCuts();
        Summary summary = DatabaseManager.getInstance(this).getDaySummary();

        FileController.getInstance(this).exportToCSV(new Date(),treeCuts, summary);
    }

    @Override
    public void onUploadedSheet(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
