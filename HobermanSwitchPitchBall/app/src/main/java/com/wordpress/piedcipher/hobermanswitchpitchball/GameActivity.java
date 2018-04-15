package com.wordpress.piedcipher.hobermanswitchpitchball;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Bundle getGameData;
    String playerOne, playerTwo;
    int playerOneImage, playerTwoImage, switchPitchImages[];

    TextView teamATextView, teamBTextView, teamAScoreTextView, teamBScoreTextView, timerTextView;
    ImageView teamAImageView, teamBImageView, teamACurrentSwitchPitch, teamBCurrentSwitchPitch;

    int scoreOfTeamA = 0, scoreOfTeamB = 0;
    String teamA, teamB;
    Toast statusMessageToast;
    Button displayResultButton;
    AlertDialog.Builder createWinnerDialog;
    AlertDialog winnerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initializer();
    }

    private void initializer() {
        getSupportActionBar().hide();
        switchPitchImages = new int[2];

        getGameData = getIntent().getExtras();
        playerOne = getGameData.getString("PlayerOne");
        playerTwo = getGameData.getString("PlayerTwo");
        playerOneImage = getGameData.getInt("PlayerOneImage");
        playerTwoImage = getGameData.getInt("PlayerTwoImage");
        switchPitchImages = getGameData.getIntArray("SwitchPitchImages");

        timerTextView = findViewById(R.id.timer_textView);
        teamATextView = findViewById(R.id.team_a);
        teamAScoreTextView = findViewById(R.id.team_a_score);
        teamAImageView = findViewById(R.id.team_a_imageView);
        teamACurrentSwitchPitch = findViewById(R.id.team_a_switch_pitch_imageView);
        teamBTextView = findViewById(R.id.team_b);
        teamBScoreTextView = findViewById(R.id.team_b_score);
        teamBImageView = findViewById(R.id.team_b_imageView);
        teamBCurrentSwitchPitch = findViewById(R.id.team_b_switch_pitch_imageView);
        displayResultButton = findViewById(R.id.view_result_button);

        displayResultButton.setVisibility(View.INVISIBLE);

        teamATextView.setText(playerOne);
        teamAImageView.setImageResource(playerOneImage);
        teamACurrentSwitchPitch.setImageResource(switchPitchImages[0]);
        teamBTextView.setText(playerTwo);
        teamBImageView.setImageResource(playerTwoImage);
        teamBCurrentSwitchPitch.setImageResource(switchPitchImages[1]);

        new CountDownTimer(10000, 1000) {
            public void onTick(long milliSecondsFinished) {
                timerTextView.setText(String.valueOf(milliSecondsFinished / 1000));
            }

            public void onFinish() {
                winnerWinnerChickenDinner();
            }
        }.start();
    }

    public void alwaysBlue(View teamData) {
        String statusMessage = "";
        switch (teamData.getId()) {
            case R.id.team_a_always_blue_button:
                if (displayNewSwitchPitch(switchPitchSwitcher(false), true)) {
                    teamAScoreTextView.setText(String.valueOf(++scoreOfTeamA));
                    statusMessage = teamA + ", BLUEEE! :D";
                } else {
                    statusMessage = "OH! That was a Yellow! :/ No Points for " + teamA;
                }
                break;
            case R.id.team_a_alwaysss_blueee_button:
                if (displayNewSwitchPitch(switchPitchSwitcher(true), true)) {
                    teamAScoreTextView.setText(String.valueOf(scoreOfTeamA += 2));
                    statusMessage = teamA + ", BLUEEE! :D";
                } else {
                    statusMessage = "OH! That was a Yellow! :/ No Points for " + teamA;
                }
                break;
            case R.id.team_b_always_blue_button:
                if (displayNewSwitchPitch(switchPitchSwitcher(false), false)) {
                    teamBScoreTextView.setText(String.valueOf(++scoreOfTeamB));
                    statusMessage = teamB + ", BLUEEE! :D";
                } else {
                    statusMessage = "OH! That was a Yellow! :/ No Points for " + teamB;
                }
                break;
            case R.id.team_b_alwaysss_blueee_button:
                if (displayNewSwitchPitch(switchPitchSwitcher(true), false)) {
                    teamBScoreTextView.setText(String.valueOf(scoreOfTeamB += 2));
                    statusMessage = teamB + ", BLUEEE! :D";
                } else {
                    statusMessage = "OH! That was a Yellow! :/ No Points for " + teamB;
                }
                break;
        }
        statusMessageToast = Toast.makeText(getApplicationContext(), statusMessage, Toast.LENGTH_SHORT);
        // statusMessageToast.show();
    }

    private boolean switchPitchSwitcher(boolean excitement) {
        boolean newSwitchPitchState = false;
        int randomNumber = new Random().nextInt(10);
        if(excitement) {
            newSwitchPitchState = randomNumber <= 5;
        } else {
            newSwitchPitchState = randomNumber >= 6;
        }
        return newSwitchPitchState;
    }

    private boolean displayNewSwitchPitch(boolean newSwitchPitchState, boolean team) {
        boolean isSwitchPitchSame = false;
        if(team) {
            if(newSwitchPitchState) {
                teamACurrentSwitchPitch.setImageResource(R.drawable.switchpitch_blue_yellow);
                isSwitchPitchSame = true;
            } else {
                teamACurrentSwitchPitch.setImageResource(R.drawable.switchpitch_yellow_blue);
            }
        } else {
            if(newSwitchPitchState) {
                teamBCurrentSwitchPitch.setImageResource(R.drawable.switchpitch_blue_yellow);
                isSwitchPitchSame = true;
            } else {
                teamBCurrentSwitchPitch.setImageResource(R.drawable.switchpitch_yellow_blue);
            }
        }
        return isSwitchPitchSame;
    }


    public void displayResult(View view) {
        winnerDialog.show();
    }

    private void winnerWinnerChickenDinner() {
        displayResultButton.setVisibility(View.VISIBLE);
        String winnerTitle = "", winnerMessage = "";
        if(scoreOfTeamA > scoreOfTeamB) {
            winnerTitle = playerOne + " Won!";
            winnerMessage = playerOne + " scored " + scoreOfTeamA + " & " + playerTwo + " scored " + scoreOfTeamB;
        } else if(scoreOfTeamB > scoreOfTeamA) {
            winnerTitle = playerTwo + " Won!";
            winnerMessage = playerTwo + " scored " + scoreOfTeamB + " & " + playerOne + " scored " + scoreOfTeamA;
        } else {
            winnerTitle = "It's a Tie!!";
            winnerMessage = playerOne + " scored " + scoreOfTeamA + " & " + playerTwo + " scored " + scoreOfTeamB;
        }

        createWinnerDialog = new AlertDialog.Builder(this);
        createWinnerDialog.setMessage(winnerTitle + "\n\n" + winnerMessage);

        createWinnerDialog.setNegativeButton("New Game!",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), PlayerActivity.class));
            }
        });

        winnerDialog = createWinnerDialog.create();
        winnerDialog.show();
    }
}
