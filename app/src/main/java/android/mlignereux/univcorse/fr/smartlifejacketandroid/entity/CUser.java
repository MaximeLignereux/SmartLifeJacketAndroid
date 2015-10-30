package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

/**
 * Created by asus on 30/10/2015.
 */
public class CUser {

    private String pseudo;

    private String pwd;

    public enum Status {ATHLETE, COACH}

    private Status status;

    public CUser(){}

    public CUser(String pPseudo, String pPwd, Status pStatus){
        this.pseudo= pPseudo;
        this.pwd = pPwd;
        this.status = pStatus;
        if(pStatus.equals(Status.ATHLETE)) new CAthlete(pPseudo,pPwd);
        else if (pStatus.equals(Status.COACH)) new CCoach(pPseudo,pPwd);
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public Status getStatus(){
        return status;
    }
}