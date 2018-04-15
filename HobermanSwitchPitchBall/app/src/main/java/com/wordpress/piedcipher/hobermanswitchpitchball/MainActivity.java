package com.wordpress.piedcipher.hobermanswitchpitchball;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
    }

    private void initializer() {
        getSupportActionBar().hide();
    }

    public void openYoutubeVideo(View openYoutubeVideoButton) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ElJe5M54brI")));
    }

    public void nextActivity(View nextButton) {
        startActivity(new Intent(getApplicationContext(), PlayerActivity.class));
    }
}
