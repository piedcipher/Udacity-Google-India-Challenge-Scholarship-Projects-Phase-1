package com.wordpress.piedcipher.hobermanswitchpitchball;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class SwitchPitchActivity extends AppCompatActivity {

    CardView switchPitchBlueYellowCardView, switchPitchBlueGreenCardView, switchPitchSkyBluePinkCardView, switchPitchGreenOrangeCardView;
    boolean isSwitchPitchBlueYellow, isSwitchPitchBlueGreen, isSwitchPitchSkyBluePink, isSwitchPitchGreenOrange;
    int currentSelectedSwitchPitchCount;
    final int SWITCH_PITCH_COUNT = 1;

    Bundle getGameData;
    String playerOne, playerTwo;
    int playerOneImage, playerTwoImage, switchPitchImageView[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchpitch);
        initializer();
    }

    private void initializer() {
        setTitle(R.string.title_activity_switchpitch);
        getGameData = getIntent().getExtras();

        switchPitchImageView = new int[2];

        playerOneImage = getGameData.getInt("PlayerOneImage");
        playerTwoImage = getGameData.getInt("PlayerTwoImage");
        playerOne = getGameData.getString("PlayerOne");
        playerTwo = getGameData.getString("PlayerTwo");

        currentSelectedSwitchPitchCount = 0;
        isSwitchPitchBlueYellow = isSwitchPitchBlueGreen = isSwitchPitchSkyBluePink = isSwitchPitchGreenOrange = false;

        switchPitchBlueYellowCardView = findViewById(R.id.switchpitch_blue_yellow);
        switchPitchBlueGreenCardView = findViewById(R.id.switchpitch_blue_green);
        switchPitchSkyBluePinkCardView = findViewById(R.id.switchpitch_skyblue_pink);
        switchPitchGreenOrangeCardView = findViewById(R.id.switchpitch_green_orange);
    }

    public void onSwitchPitchClick(View switchPitch) {
        if (currentSelectedSwitchPitchCount == SWITCH_PITCH_COUNT) {
            unselectSwitchPitch(switchPitch);
            Toast.makeText(getApplicationContext(), "Please Select Only 1 SwitchPitch Ball!", Toast.LENGTH_SHORT).show();
        } else {
            selectSwitchPitch(switchPitch);
        }
    }

    public void nextActivity(View nextButton) {
        if (currentSelectedSwitchPitchCount == SWITCH_PITCH_COUNT) {
            startActivity(new Intent(getApplicationContext(), GameActivity.class)
                    .putExtra("PlayerOne", playerOne)
                    .putExtra("PlayerTwo", playerTwo)
                    .putExtra("PlayerOneImage", playerOneImage)
                    .putExtra("PlayerTwoImage", playerTwoImage)
                    .putExtra("SwitchPitchImages", switchPitchImageView)
            );
        } else {
            Toast.makeText(getApplicationContext(), "Select A SwitchPitch Ball to Proceed Next!", Toast.LENGTH_SHORT).show();
        }
    }

    public void previousActivity(View previousButton) {
        finish();
    }

    private void selectSwitchPitch(View switchPitchCard) {
        switch (switchPitchCard.getId()) {
            case R.id.switchpitch_blue_yellow:
                if (!isSwitchPitchBlueYellow) {
                    switchPitchCard.setBackgroundColor(Color.parseColor("#AED581"));
                    isSwitchPitchBlueYellow = true;
                    switchPitchImageView[0] = R.drawable.switchpitch_blue_yellow;
                    switchPitchImageView[1] = R.drawable.switchpitch_yellow_blue;
                    currentSelectedSwitchPitchCount++;
                } else {
                    unselectSwitchPitch(switchPitchCard);
                }
                break;
            case R.id.switchpitch_blue_green:
                if (!isSwitchPitchBlueGreen) {
                    switchPitchCard.setBackgroundColor(Color.parseColor("#AED581"));
                    isSwitchPitchBlueGreen = true;
                    switchPitchImageView[0] = R.drawable.switchpitch_blue_green;
                    switchPitchImageView[1] = R.drawable.switchpitch_green_blue;
                    currentSelectedSwitchPitchCount++;
                } else {
                    unselectSwitchPitch(switchPitchCard);
                }
                break;
            case R.id.switchpitch_skyblue_pink:
                if (!isSwitchPitchSkyBluePink) {
                    switchPitchCard.setBackgroundColor(Color.parseColor("#AED581"));
                    isSwitchPitchSkyBluePink = true;
                    switchPitchImageView[0] = R.drawable.switchpitch_skyblue_pink;
                    switchPitchImageView[1] = R.drawable.switchpitch_pink_skyblue;
                    currentSelectedSwitchPitchCount++;
                } else {
                    unselectSwitchPitch(switchPitchCard);
                }
                break;
            case R.id.switchpitch_green_orange:
                if (!isSwitchPitchGreenOrange) {
                    switchPitchCard.setBackgroundColor(Color.parseColor("#AED581"));
                    isSwitchPitchGreenOrange = true;
                    switchPitchImageView[0] = R.drawable.switchpitch_green_orange;
                    switchPitchImageView[1] = R.drawable.switchpitch_orange_green;
                    currentSelectedSwitchPitchCount++;
                } else {
                    unselectSwitchPitch(switchPitchCard);
                }
                break;
        }
    }

    private void unselectSwitchPitch(View switchPitch) {
        switch (switchPitch.getId()) {
            case R.id.switchpitch_blue_yellow:
                if (isSwitchPitchBlueYellow) {
                    switchPitch.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isSwitchPitchBlueYellow = false;
                    currentSelectedSwitchPitchCount--;
                }
                break;
            case R.id.switchpitch_blue_green:
                if (isSwitchPitchBlueGreen) {
                    switchPitch.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isSwitchPitchBlueGreen = false;
                    currentSelectedSwitchPitchCount--;
                }
                break;
            case R.id.switchpitch_skyblue_pink:
                if (isSwitchPitchSkyBluePink) {
                    switchPitch.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isSwitchPitchSkyBluePink = false;
                    currentSelectedSwitchPitchCount--;
                }
                break;
            case R.id.switchpitch_green_orange:
                if (isSwitchPitchGreenOrange) {
                    switchPitch.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isSwitchPitchGreenOrange = false;
                    currentSelectedSwitchPitchCount--;
                }
                break;
        }
    }
}
