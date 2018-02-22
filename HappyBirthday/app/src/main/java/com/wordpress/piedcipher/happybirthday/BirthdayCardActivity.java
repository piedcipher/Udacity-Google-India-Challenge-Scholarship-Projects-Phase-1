package com.wordpress.piedcipher.happybirthday;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class BirthdayCardActivity extends AppCompatActivity {

    private ImageView birthdayCardBackgroundImage;
    int currentBackground = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_card);

        Bundle birthdayCardData = getIntent().getExtras();

        TextView birthdayWishFrom = findViewById(R.id.happy_birthday_from_TextView);
        TextView birthdayWishTo = findViewById(R.id.happy_birthday_to_TextView);

        String wishFrom = "From, " + birthdayCardData.getString("wishFrom") + ".";
        String wishTo = "Happy birthday, " + birthdayCardData.getString("wishTo") + "!";

        setTitle("Birthday Card for \"" + birthdayCardData.getString("wishTo") + "\"");
        birthdayWishTo.setText(wishTo);
        birthdayWishFrom.setText(wishFrom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.change_card:
                birthdayCardBackgroundImage = findViewById(R.id.birthday_card_background_image);
                if(currentBackground == 0) {
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary_2)));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_2));
                    birthdayCardBackgroundImage.setImageResource(R.drawable.birthday_card_background_1);
                    currentBackground = 1;
                } else {
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                    birthdayCardBackgroundImage.setImageResource(R.drawable.birthday_card_background_2);
                    currentBackground = 0;
                }
                return true;
            case R.id.new_card:
                currentBackground = 0;
                birthdayCardBackgroundImage.setBackgroundResource(R.drawable.birthday_card_background_2);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
