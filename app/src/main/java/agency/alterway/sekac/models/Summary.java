package agency.alterway.sekac.models;

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
        return String.valueOf(totalMatter);
    }

    public String getFormattedVolume()
    {
        return String.valueOf(totalVolume);
    }

    public String getFormattedNoOfCuts()
    {
        return noOfCuts+" stromov";
    }

    private void initiateMatter(int value, ParameterType type)
    {
        try
        {
            switch (type)
            {
                case NO_OF_CUTS:
                    this.totalMatter = this.totalVolume / value;
                    break;
                case VOLUME:
                    this.totalMatter = value / this.noOfCuts;
                    break;
            }
        }
        catch (NullPointerException e)
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

