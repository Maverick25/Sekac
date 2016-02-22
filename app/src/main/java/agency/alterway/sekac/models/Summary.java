package agency.alterway.sekac.models;

/**
 * Model object representing cut data of the whole day
 *
 * Created by marekrigan on 22/02/16.
 */
public class Summary
{
    private int noOfCuts;
    private int totalHeight;
    private int totalWidth;
    private int totalVolume;

    public Summary() {}

    public Summary(int noOfCuts, int totalHeight, int totalWidth, int totalVolume)
    {
        this.noOfCuts = noOfCuts;
        this.totalHeight = totalHeight;
        this.totalWidth = totalWidth;
        this.totalVolume = totalVolume;
    }

    public String getFormattedHeight()
    {
        return String.valueOf(totalHeight);
    }

    public String getFormattedWidth()
    {
        return String.valueOf(totalWidth);
    }

    public String getFormattedVolume()
    {
        return String.valueOf(totalVolume);
    }

    public String getFormattedNoOfCuts()
    {
        return noOfCuts+" stromov";
    }

    public int getNoOfCuts()
    {
        return noOfCuts;
    }

    public void setNoOfCuts(int noOfCuts)
    {
        this.noOfCuts = noOfCuts;
    }

    public int getTotalHeight()
    {
        return totalHeight;
    }

    public void setTotalHeight(int totalHeight)
    {
        this.totalHeight = totalHeight;
    }

    public int getTotalWidth()
    {
        return totalWidth;
    }

    public void setTotalWidth(int totalWidth)
    {
        this.totalWidth = totalWidth;
    }

    public int getTotalVolume()
    {
        return totalVolume;
    }

    public void setTotalVolume(int totalVolume)
    {
        this.totalVolume = totalVolume;
    }
}

