package android.mlignereux.univcorse.fr.smartlifejacketandroid.model;

/**
 * Created by asus on 30/10/2015.
 */
public class CPerformance {

    public static final String FIELD_ID = "id";
    public static final String FIELD_ATHLETE = "athlete";
    public static final String FIELD_TRAINING = "training";
    public static final String FIELD_CHRONO = "chrono";
    public static final String FIELD_CARDIACFREQUENCY = "cardiacfrequency";
    public static final String FIELD_DISTANCETRAVELED = "distancetraveled";
    public static final String FIELD_VIDEO = "video";

    private int id;

    CTraining training;

    CAthlete athlete;

    CChrono chrono;

    CCardiacFrequency cardiacFrequency;

    CDistanceTraveled distanceTraveled;

    CVideo video;

    int test;

    public CPerformance(){}

    public CTraining getTraining() {
        return training;
    }

    public CAthlete getAthlete(){
        return athlete;
    }

    public CPerformance(int test){
        this.test = test;
    }

    public CChrono getChrono() {
        return chrono;
    }

    public CCardiacFrequency getCardiacFrequency() {
        return cardiacFrequency;
    }

    public CDistanceTraveled getDistanceTraveled() {
        return distanceTraveled;
    }

    public CVideo getVideo() {
        return video;
    }

    @Override
    public String toString() {
        return "CPerformance{" +
                "chrono=" + test +
                '}';
    }
}

