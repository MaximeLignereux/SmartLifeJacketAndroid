package android.mlignereux.univcorse.fr.smartlifejacketandroid.activity;

import android.content.Intent;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.R;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CUser;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment.CHomeFragment;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment.CProfilFragment;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment.CSettingsFragment;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment.CStatFragment;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.fragment.CTrainingFragment;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.util.CUtils;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class CHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CUser mUser;
    private FragmentManager mFragmentManager;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                Intent intent = new Intent(CHomeActivity.this, CNewTrainingActivity.class);
                startActivity(intent);
            }
        });
        fab.hide();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        try {
            fragment = (Fragment)CHomeFragment.class.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mFragmentManager.beginTransaction().replace(R.id.container,fragment ).commit();

        mUser = CUtils.getSharedPreferenceUser(CHomeActivity.this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;

        Class fragmentClass;
        fab.hide();
        switch (id){
            case R.id.nav_home:
                fragmentClass = CHomeFragment.class;
                break;
            case R.id.nav_training:
                fragmentClass = CTrainingFragment.class;
                fab.show();
                break;
            case R.id.nav_stat:
                fragmentClass = CStatFragment.class;
                break;
            case R.id.nav_profile:
                fragmentClass = CProfilFragment.class;
                break;
            case R.id.nav_settings:
                fragmentClass = CSettingsFragment.class;
                break;
            default:
                fragmentClass = CHomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
