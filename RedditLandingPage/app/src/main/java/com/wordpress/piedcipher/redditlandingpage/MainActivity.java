package com.wordpress.piedcipher.redditlandingpage;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.BLACK);
    }

    public void knowMore(View redditLogo) {
        startActivity(new Intent(getApplicationContext(), RedditFeaturesActivity.class));
    }

    public void openGooglePlayStore(View getItOnGooglePlay) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.reddit.frontpage")));
    }

    public void openAppleAppStore(View availableOnAppStore) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://itunes.apple.com/us/app/reddit-official-trending-news/id1064216828")));
    }
}