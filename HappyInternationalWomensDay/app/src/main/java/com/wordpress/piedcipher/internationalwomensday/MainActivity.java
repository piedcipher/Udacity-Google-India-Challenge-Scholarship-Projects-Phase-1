package com.wordpress.piedcipher.internationalwomensday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void whichDoodle(View whichView) {
        int googleDoodle = 0;
        String googleDoodleYear = "";
        Intent sendGoogleDoodleData = new Intent(getApplicationContext(), GoogleDoodleActivity.class);
        switch (whichView.getId()) {
            case R.id.iwd_2005:
                googleDoodle = R.drawable.google_doodle_iwd_2005;
                googleDoodleYear = "2005";
                break;
            case R.id.iwd_2009:
                googleDoodle = R.drawable.google_doodle_iwd_2009;
                googleDoodleYear = "2009";
                break;
            case R.id.iwd_2011:
                googleDoodle = R.drawable.google_doodle_iwd_2011;
                googleDoodleYear = "2011";
                break;
            case R.id.iwd_2012:
                googleDoodle = R.drawable.google_doodle_iwd_2012;
                googleDoodleYear = "2012";
                break;
            case R.id.iwd_2013:
                googleDoodle = R.drawable.google_doodle_iwd_2013;
                googleDoodleYear = "2013";
                break;
            case R.id.iwd_2014:
                googleDoodle = R.drawable.google_doodle_iwd_2014;
                googleDoodleYear = "2014";
                break;
            case R.id.iwd_2015:
                googleDoodle = R.drawable.google_doodle_iwd_2015;
                googleDoodleYear = "2015";
                break;
            case R.id.iwd_2016:
                googleDoodle = R.drawable.google_doodle_iwd_2016;
                googleDoodleYear = "2016";
                break;
            case R.id.iwd_2017:
                googleDoodle = R.drawable.google_doodle_iwd_2017;
                googleDoodleYear = "2017";
                break;
            case R.id.iwd_2018:
                googleDoodle = R.drawable.google_doodle_iwd_2018;
                googleDoodleYear = "2018";
                break;
        }
        sendGoogleDoodleData.putExtra("googleDoodle", googleDoodle);
        sendGoogleDoodleData.putExtra("googleDoodleYear", googleDoodleYear);
        startActivity(sendGoogleDoodleData);
    }
}
