package agency.alterway.sekac.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.DatePicker;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import agency.alterway.sekac.R;
import agency.alterway.sekac.utils.DateHandler;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalendarActivity extends AppCompatActivity
{
    private Calendar calendar;

    @Bind(R.id.datePicker_summary)
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);

        calendar = Calendar.getInstance();

        String dateString = getIntent().getStringExtra(getString(R.string.key_current_date));

        if (dateString != null)
        {
            try
            {
                Date currentDate = DateHandler.formatter.parse(dateString);
                calendar.setTime(currentDate);

                datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

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
    }

    @OnClick(R.id.button_cancel)
    void onCancel()
    {
        goBack();
    }

    @OnClick(R.id.button_saveDate)
    void onSavedDate()
    {
        calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

        String dateString = DateHandler.formatter.format(calendar.getTime());
        Intent goBack = new Intent();
        goBack.putExtra(getString(R.string.key_current_date), dateString);
        setResult(RESULT_OK, goBack);
        goBack();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        goBack();
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

    private void goBack()
    {
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
