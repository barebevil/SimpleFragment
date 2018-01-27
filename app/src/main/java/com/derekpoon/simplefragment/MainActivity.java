package com.derekpoon.simplefragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/*
Activities are navigation controllers
- Display or hide fragments using the fragment manager.
- Communication between activities and fragments

 */

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;
    private final String FRAGMENT_TAG = "mainfrag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if the fragment exists
        if (savedInstanceState != null) {
            // look up the instance that already exists by tag
            mainFragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
            //if fragment doesn't exist, example, launching the app for the first time
        } else if (mainFragment == null) {
            // create a new fragment
            mainFragment = new MainFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, mainFragment, FRAGMENT_TAG);
            ft.commit();
        }
    }
}
