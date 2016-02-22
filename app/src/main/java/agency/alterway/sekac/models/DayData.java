package agency.alterway.sekac.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Model object representing cut data of the whole day
 *
 * Created by marekrigan on 22/02/16.
 */
public class DayData
{
    private int  noOfCuts;
    private Date selectedDate;
    private int  volume;

    public DayData() {}

    public DayData(Date selectedDate)
    {
        this.selectedDate = selectedDate;
        this.noOfCuts = 0;
        this.volume = 0;
    }

    public DayData(Date selectedDate, int volume, int noOfCuts)
    {
        this.selectedDate = selectedDate;
        this.volume = volume;
        this.noOfCuts = noOfCuts;
    }

    public String getFormattedDate()
    {
        return new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(this.selectedDate);
    }

    public String getFormattedVolume()
    {
        DecimalFormat localDecimalFormat = new DecimalFormat("#0.00");
        return localDecimalFormat.format(this.volume * 0.01D) + " m��";
    }

    public int getNoOfCuts()
    {
        return this.noOfCuts;
    }

    public Date getSelectedDate()
    {
        return this.selectedDate;
    }

    public double getVolume()
    {
        return this.volume;
    }

    public void setNoOfCuts(int paramInt)
    {
        this.noOfCuts = paramInt;
    }

    public void setSelectedDate(Date paramDate)
    {
        this.selectedDate = paramDate;
    }

    public void setVolume(int paramInt)
    {
        this.volume = paramInt;
    }
}

