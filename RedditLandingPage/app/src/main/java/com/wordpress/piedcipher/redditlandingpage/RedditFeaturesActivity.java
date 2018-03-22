package com.wordpress.piedcipher.redditlandingpage;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RedditFeaturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddit_features);
        getWindow().setStatusBarColor(Color.BLACK);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Closing..", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                finish();
            }
        });
    }

    public void openGooglePlayStore(View getItOnGooglePlay) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.reddit.frontpage")));
    }

    public void openAppleAppStore(View availableOnAppStore) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://itunes.apple.com/us/app/reddit-official-trending-news/id1064216828")));
    }
}