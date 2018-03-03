package com.wordpress.piedcipher.tvshowcards;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Bundle characterData = getIntent().getExtras();
        String characterName = characterData.getString("characterName");
        String characterQuote = characterData.getString("characterQuote");
        String characterWork = characterData.getString("characterWork");
        int characterImage = characterData.getInt("characterImage");
        String characterPrimaryColor = characterData.getString("characterPrimaryColor");
        String characterPrimaryColorDark = characterData.getString("characterPrimaryColorDark");

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(characterPrimaryColor)));
        getWindow().setStatusBarColor(Color.parseColor(characterPrimaryColorDark));

        setTitle(characterName);

        ScrollView text_RelativeLayout = findViewById(R.id.root_layout);
        text_RelativeLayout.setBackgroundColor(Color.parseColor(characterPrimaryColor));

        TextView characeterWorkTextView = findViewById(R.id.work_TextView);
        characeterWorkTextView.setText(characterWork);
        characeterWorkTextView.setTextColor(Color.parseColor(characterPrimaryColor));

        TextView characeterNameTextView = findViewById(R.id.name_TextView);
        characeterNameTextView.setText(characterName);

        TextView characeterQuoteTextView = findViewById(R.id.quote_TextView);
        characeterQuoteTextView.setText(characterQuote);

        ImageView characterImageView = findViewById(R.id.character_ImageView);
        characterImageView.setImageDrawable(getResources().getDrawable(characterImage));

    }
}
