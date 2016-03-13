package agency.alterway.sekac.models;

import java.text.DecimalFormat;

/**
 * Model object representing cut data of the whole day
 *
 * Created by marekrigan on 22/02/16.
 */
public class Summary
{
    private int noOfCuts;
    private int totalVolume;
    private double totalMatter;

    public Summary() {}

    public String getFormattedMatter()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(totalMatter);
    }

    public String getFormattedVolume()
    {
        return String.valueOf(totalVolume);
    }

    public String getFormattedNoOfCuts()
    {
        String formatted = noOfCuts+" ";

        switch (noOfCuts)
        {
            case 1:
                formatted = formatted.concat("strom");
                break;
            case 2:
            case 3:
            case 4:
                formatted = formatted.concat("stromy");
                break;
            default:
                formatted = formatted.concat("stromov");
        }
        return formatted;
    }

    private void initiateMatter(int value, ParameterType type)
    {
        try
        {
            switch (type)
            {
                case NO_OF_CUTS:
                    this.totalMatter =(double) this.totalVolume / value;
                    break;
                case VOLUME:
                    this.totalMatter = (double)value / this.noOfCuts;
                    break;
            }
        }
        catch (NullPointerException | ArithmeticException e)
        {
            e.printStackTrace();
        }
    }

    public void setNoOfCuts(int noOfCuts)
    {
        initiateMatter(noOfCuts, ParameterType.NO_OF_CUTS);

        this.noOfCuts = noOfCuts;
    }

    public void setTotalVolume(int totalVolume)
    {
        initiateMatter(totalVolume, ParameterType.VOLUME);

        this.totalVolume = totalVolume;
    }
}

