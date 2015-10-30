package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

/**
 * Created by asus on 30/10/2015.
 */
public class CChrono {

    public static final String FIEL_ID = "id";
    public static final String FIELD_HOUR = "hour";
    public static final String FIELD_MINUTE = "minute";
    public static final String FIELD_SECOND = "second";
    public static final String FIELD_MILLISECOND = "millisecond";
    public static final String FIELD_PENALITY = "penality";
    public static final String FIELD_PERFORMANCE = "performance";


    private int id;

    private int hour;

    private int minute;

    private int second;

    private long millisecond;

    private int penality;

    private CPerformance performance;

    public CChrono(){}

    public CChrono(CPerformance pPerformance, int pHour, int pMinute, int pSecond, long pMillisecond, int pPenality){
        this.performance = pPerformance;
        this.hour = pHour;
        this.minute = pMinute;
        this.second  = pSecond;
        this.millisecond = pMillisecond;
        this.penality = pPenality;
    }

    public int getId() {
        return id;
    }

    public int getPenality() {
        return penality;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public long getMillisecond() {
        return millisecond;
    }

    public CPerformance getPerformance() {
        return performance;
    }
}

