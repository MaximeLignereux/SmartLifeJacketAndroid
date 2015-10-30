package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

/**
 * Created by asus on 30/10/2015.
 */
public class CDistanceTraveled {

    public static final String FIELD_ID = "id";
    public static final String FIELD_DISTANCE = "distance";
    public static final String FIELD_PERFORMANCE= "performance";

    private int id;

    private CPerformance performance;

    private int distance;

    public int getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public CPerformance getPerformance() {
        return performance;
    }

    public void setPerformance(CPerformance performance) {
        this.performance = performance;
    }
}
