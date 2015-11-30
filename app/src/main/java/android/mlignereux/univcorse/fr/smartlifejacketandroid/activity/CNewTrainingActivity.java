package android.mlignereux.univcorse.fr.smartlifejacketandroid.activity;

import android.mlignereux.univcorse.fr.smartlifejacketandroid.R;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CAthlete;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CCoach;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.util.CUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class CNewTrainingActivity extends AppCompatActivity {

    private CCoach mUser;

    private View mDateTextView;
    private View mHourTextView;
    private View mDescriptionTextView;

    private List<CAthlete> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_training);

        mDateTextView = (EditText)findViewById(R.id.new_training_date);
        mHourTextView = (EditText)findViewById(R.id.new_training_time);
        mDescriptionTextView = (EditText)findViewById(R.id.new_training_description);


        mUser = CUtils.getSharedPreferenceCoach(CNewTrainingActivity.this);
        Log.d("CNewTrainingActivity", "User: " + mUser);

        users = mUser.getAthletes();


    }




}
