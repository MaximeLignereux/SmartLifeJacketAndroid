package android.mlignereux.univcorse.fr.smartlifejacketandroid.model;

/**
 * Created by asus on 30/10/2015.
 */
public class CCardiacFrequency {

    public static final String FIELD_ID = "id";
    public static final String FIELD_AVERAGE = "average";
    public static final String FIELD_MIN= "min";
    public static final String FIELD_MAX= "max";
    public static final String FIELD_PERFORMANCE= "performance";

    private int id;

    private CPerformance performance;

    private int average;

    private int min;

    private int max;


    public int getId() {
        return id;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public CPerformance getPerformance() {
        return performance;
    }

    public void setPerformance(CPerformance performance) {
        this.performance = performance;
    }
}

