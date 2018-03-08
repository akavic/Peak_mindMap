package com.victor.bobby_000_.peak_mindmap;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//has to implement topsection so classs can call selectpos and retrive the data from it
public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopsectionListner {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

    }


    @Override
    public void selectpos(int pos) {
        // the position selected from the top section get's passed through cuase of the interface
        //this value is then passed onto the second fragment by the shareoption() methods which takes the pos as a parameter

        BottomSectionFragment Frag = (BottomSectionFragment) getSupportFragmentManager().findFragmentById(R.id.bottomsection);

        Frag.setshapeoption(pos);
    }
}
