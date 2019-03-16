package agency.alterway.sekac.models;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

/**
 * Model object representing cut data of the whole day
 * <p>
 * Created by marekrigan on 22/02/16.
 */
public class Summary {
    private int noOfCuts;
    private double totalVolume;
    private double totalMatter;

    public Summary() {
    }

    public String getFormattedMatter() {
        if (Double.isNaN(totalMatter)) {
            return "0";
        } else {
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(totalMatter);
        }
    }

    public String getFormattedVolume() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(totalVolume);
    }

    public String getFormattedNoOfCuts() {
        String formatted = noOfCuts + " ";

        switch (noOfCuts) {
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

    private void initiateMatter(@Nullable Integer noOfCuts, @Nullable Double volume) {
        try {
            if (noOfCuts == null) {
                this.totalMatter = volume / this.noOfCuts;
            } else if (volume == null) {
                this.totalMatter = this.totalVolume / noOfCuts;
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException | ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public void setNoOfCuts(int noOfCuts) {
        initiateMatter(noOfCuts, null);

        this.noOfCuts = noOfCuts;
    }

    public void setTotalVolume(int totalVolume) {
        double realVolume = (double) totalVolume / 100;

        initiateMatter(null, realVolume);

        this.totalVolume = realVolume;
    }
}

