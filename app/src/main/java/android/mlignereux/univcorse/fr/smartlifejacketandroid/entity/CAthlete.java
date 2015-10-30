package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 30/10/2015.
 */
public class CAthlete extends CUser {

    public static final String FIELD_ID = "id";
    public static final String FIELD_PSEUDO = "pseudo";
    public static final String FIELD_PASSWORD= "password";
    public static final String FIELD_COACHS= "coachs";
    public static final String FIELD_PERFORMANCE= "performance";
    public static final String FIELD_TRAININGS= "trainings";

    private int id;

    private String pseudo ;

    private String password;

    private List<CTraining> trainings;

    private List<CCoach> coachs;

    private List<CPerformance> performances;

    public CAthlete(){}

    public CAthlete(String pPseudo, String pPwd) {
        super(pPseudo, pPwd, Status.ATHLETE);
        this.pseudo = pPseudo;
        this.password = pPwd;
        trainings = new ArrayList<CTraining>();
    }

    public List<CTraining> getTrainings(){
        return trainings;
    }

    public List<CPerformance> getPerformances(CTraining pTraining){
        List<CPerformance> result = new ArrayList<CPerformance>();

        return result;
    }

    public static CAthlete create(String pPseudo, String pPwd){
        return new CAthlete(pPseudo, pPwd);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTrainings(List<CTraining> trainings) {
        this.trainings = trainings;
    }

    public List<CCoach> getCoachs() {
        return coachs;
    }

    public void setCoachs(List<CCoach> coachs) {
        this.coachs = coachs;
    }

    public List<CPerformance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<CPerformance> performances) {
        this.performances = performances;
    }

    @Override
    public String toString() {
        return "CAthlete{" +
                "trainings=" + trainings +
                '}';
    }
}
