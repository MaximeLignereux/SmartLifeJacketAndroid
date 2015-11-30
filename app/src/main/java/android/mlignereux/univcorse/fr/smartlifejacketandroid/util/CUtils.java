package android.mlignereux.univcorse.fr.smartlifejacketandroid.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CAthlete;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CCoach;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CUser;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

/**
 * Created by asus on 30/10/2015.
 */
public class CUtils {


    public static void setSharedPreferencesAthlete(Activity pActivity,CAthlete pUser){
        Gson gson = new Gson();
        System.out.println(pUser);
        String user = gson.toJson(pUser);

        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(pActivity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",user);
        editor.commit();
    }

    public static void setSharedPreferencesCoach(Activity pActivity,CCoach pUser){
        Gson gson = new Gson();
        System.out.println(pUser);
        String user = gson.toJson(pUser);

        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(pActivity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",user);
        editor.commit();
    }

    public static CCoach getSharedPreferenceCoach(Activity pActivity){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(pActivity);
        Gson gson = new Gson();
        String userAsString =  prefs.getString("user", null);

        return gson.fromJson(userAsString,CCoach.class);
    }

    public static CAthlete getSharedPreferenceAthlete(Activity pActivity){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(pActivity);
        Gson gson = new Gson();
        String userAsString =  prefs.getString("user", null);

        return gson.fromJson(userAsString,CAthlete.class);
    }

    public static CUser getSharedPreferenceUser(Activity pActivity) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(pActivity);
        Gson gson = new Gson();
        String userAsString =  prefs.getString("user", null);

        return gson.fromJson(userAsString,CUser.class);
    }
}
