package android.mlignereux.univcorse.fr.smartlifejacketandroid.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.R;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.dao.CAthleteDAO;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.dao.CCoachDAO;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CAthlete;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CUser;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.util.CUtils;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.springframework.http.HttpStatus;

public class CRegisterActivity extends AppCompatActivity {

    private Intent mIntent;

    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mRepasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private RadioGroup mStatusRadioGroup;

    private UserRegisterTask mAuthTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailView = (EditText)findViewById(R.id.email_register);
        mPasswordView = (EditText)findViewById(R.id.password_register);
        mRepasswordView = (EditText)findViewById(R.id.repassword);

        Button mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.register_form);
        mProgressView = findViewById(R.id.login_progress_register);

        mStatusRadioGroup = (RadioGroup)findViewById(R.id.status_radiogroup);

    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);
        mRepasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String repassword = mRepasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (!repassword.equals(password)) {
            mRepasswordView.setError(getString(R.string.error_incorrect_repassword));
            focusView = mRepasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);

            mAuthTask = new UserRegisterTask(
                    email,
                    repassword,
                    getStatus(mStatusRadioGroup.getCheckedRadioButtonId()));
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@") && !email.contains(" ");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserRegisterTask extends AsyncTask<Void, Void, HttpStatus> {

        private final String mEmail;
        private final String mPassword;
        private final CUser.Status mStatus;

        UserRegisterTask(String email, String password, CUser.Status status) {
            mEmail = email;
            mPassword = password;
            mStatus = status;
        }


        @Override
        protected HttpStatus doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            CAthleteDAO athleteDAO = new CAthleteDAO();
            CCoachDAO coachDAO = new CCoachDAO();
            HttpStatus status = null;
            //if(mStatus == CUser.Status.ATHLETE)
                status = athleteDAO.create(new CAthlete(mEmail,mPassword,mStatus));

            //else if (mStatus == CUser.Status.COACH);



            return status;
        }

        @Override
        protected void onPostExecute(final HttpStatus success) {
            mAuthTask = null;
            showProgress(false);

            if(success.value() == 201) {
                finish();
                mIntent = new Intent(CRegisterActivity.this, CHomeActivity.class);
                CUtils.setSharedPreferences(CRegisterActivity.this, new CUser(mEmail, mPassword, mStatus));
                startActivity(mIntent);
            }else if (success.value() == 302){
                    mEmailView.setError(getString(R.string.error_incorrect_email));
                    mEmailView.requestFocus();
                Log.d("CRegisterActivity", "status: "+ success.value());
            }else{
                Toast.makeText(getApplicationContext(),"Erreur: "+success.value(), Toast.LENGTH_LONG);
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

    public CUser.Status getStatus(int pId){
        CUser.Status status = null;

        if(pId == R.id.athlete_radiobutton) status = CUser.Status.ATHLETE;
        else if (pId == R.id.coach_radiobutton) status = CUser.Status.COACH;

        return status;
    }


}
