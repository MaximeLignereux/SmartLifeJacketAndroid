package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 30/10/2015.
 */
public class CTraining {

    public static final String FIELD_ID = "id";
    public static final String FIELD_ATHLETES = "athletes";
    public static final String FIELD_COACH = "coach";

    private int id;

    private List<CAthlete> athletes;

    private CCoach coach;

    public CTraining(){
        athletes = new ArrayList<CAthlete>();
    }

    public int getId() {
        return id;
    }

    public List<CAthlete> getAthletes() {
        return athletes;
    }


    public void addPerformance(CPerformance performance) {
        //this.performances.add(performance);
    }

    public void addAthlete(CAthlete pAthlete)
    {
        this.getAthletes().add(pAthlete);
        pAthlete.getTrainings().add(this);
    }

    @Override
    public String toString() {
        return "CTraining{" +
                "id=" + id +
                '}';
    }
}

