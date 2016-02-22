package agency.alterway.sekac.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import agency.alterway.sekac.R;
import agency.alterway.sekac.db.DatabaseManager;
import agency.alterway.sekac.models.Summary;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SummaryActivity extends AppCompatActivity
{
    @Bind(R.id.button_dateChange)
    Button   dateChangeButton;
    @Bind(R.id.text_totalCount)
    TextView totalCountLabel;
    @Bind(R.id.text_totalHeight)
    TextView totalHeightLabel;
    @Bind(R.id.text_totalWidth)
    TextView totalWidthLabel;
    @Bind(R.id.text_totalVolume)
    TextView totalVolumeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);

        Summary summary = DatabaseManager.getInstance(this).getDaySummary();

        SimpleDateFormat formatter = new SimpleDateFormat("dd. MMMM yyyy", Locale.getDefault());

        dateChangeButton.setText(formatter.format(new Date()));
        totalCountLabel.setText(summary.getFormattedNoOfCuts());
        totalHeightLabel.setText(summary.getFormattedHeight());
        totalWidthLabel.setText(summary.getFormattedWidth());
        totalVolumeLabel.setText(summary.getFormattedVolume());
    }
}
