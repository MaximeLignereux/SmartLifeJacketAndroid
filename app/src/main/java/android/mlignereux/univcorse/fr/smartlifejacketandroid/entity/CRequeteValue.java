package android.mlignereux.univcorse.fr.smartlifejacketandroid.entity;

import org.springframework.http.HttpStatus;

/**
 * Created by asus on 27/11/2015.
 */
public final class CRequeteValue {

    private HttpStatus status;
    private CUser user;

    public CRequeteValue(HttpStatus pStatus, CUser pUser){
        this.status = pStatus;
        this.user = pUser;
    }

    public CUser getUser() {
        return user;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
