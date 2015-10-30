package android.mlignereux.univcorse.fr.smartlifejacketandroid.controller;

import android.content.Intent;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.activity.CAuthActivity;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.activity.CHomeActivity;

/**
 * Created by asus on 30/10/2015.
 */
public class CAuthController {

    private CAuthActivity mAuthAcitvity;

    public CAuthController(CAuthActivity pAuthActivity){
        this.mAuthAcitvity = pAuthActivity;
    }

    public void goToHomeActivity() {
        Intent intent = new Intent(mAuthAcitvity, CHomeActivity.class);
        mAuthAcitvity.startActivity(intent);
    }
}
