package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

import java.util.List;

/**
 * Created by asus on 30/10/2015.
 */
public class CCoach extends CUser {

    public static final String FIELD_ID = "id";
    public static final String FIELD_PSEUDO = "pseudo";
    public static final String FIELD_PASSWORD= "password";
    public static final String FIELD_ATHLETES= "athletes";
    public static final String FIELD_TRAININGS= "trainings";

    private int id;

    private String pseudo ;

    private String password;

    private List<CAthlete> athletes;

    private List<CTraining> trainings;

    public CCoach(){}

    public CCoach(String pPseudo, String pPwd) {
        super(pPseudo, pPwd, Status.COACH);
        this.pseudo = pPseudo;
        this.password = pPwd;
    }
}
