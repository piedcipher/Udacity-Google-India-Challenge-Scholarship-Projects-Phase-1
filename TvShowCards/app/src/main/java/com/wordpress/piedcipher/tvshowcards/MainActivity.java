package com.wordpress.piedcipher.tvshowcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.activity_main_actionbar);
    }

    public void getThisTvShowData(View view) {
        String tvShow = "";
        switch (view.getId()) {
            case R.id.show_silicon_valley_ImageView:
                tvShow = getResources().getString(R.string.show_silicon_valley);
                break;
            case R.id.show_death_note_ImageView:
                tvShow = getResources().getString(R.string.show_death_note);
                break;
            case R.id.show_friends:
                tvShow = "F.R.I.E.N.D.S";
                break;
            case R.id.show_rick_and_morty_ImageView:
                tvShow = getResources().getString(R.string.show_rick_and_morty);
                break;
        }

        Intent sendThisShowData = new Intent(this, CharacterActivity.class);
        sendThisShowData.putExtra("tvShow", tvShow);
        startActivity(sendThisShowData);
    }
}
