package com.wordpress.piedcipher.internationalwomensday;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GoogleDoodleActivity extends AppCompatActivity {

    String googleDoodleYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_doodle);

        Bundle googleDoodleData = getIntent().getExtras();
        int googleDoodle = googleDoodleData.getInt("googleDoodle");
        String googleDoodleYear = "Google Doodle IWD " + googleDoodleData.getString("googleDoodleYear");
        setTitle(googleDoodleYear);

        this.googleDoodleYear = googleDoodleData.getString("googleDoodleYear");
        ImageView googleDoodleImageView = findViewById(R.id.google_doodle_ImageView);
        googleDoodleImageView.setImageResource(googleDoodle);
    }

    public void thisGoogleDoodleSource(View googleDoodleImageView) {
        resolveThisGoogleDoodleSource(googleDoodleYear);
    }

    public void resolveThisGoogleDoodleSource(String googleDoodleYear) {
        String googleDoodleSource = "https://www.google.com/doodles/";
        if(googleDoodleYear.equals("2011") || googleDoodleYear.equals("2012") || googleDoodleYear.equals("2013"))
            googleDoodleSource += "womens-day-" +googleDoodleYear;
        else
            googleDoodleSource += "international-womens-day-" + googleDoodleYear;

        Intent visitGoogleDoodleSource = new Intent(Intent.ACTION_VIEW, Uri.parse(googleDoodleSource));
        startActivity(visitGoogleDoodleSource);
    }
}
