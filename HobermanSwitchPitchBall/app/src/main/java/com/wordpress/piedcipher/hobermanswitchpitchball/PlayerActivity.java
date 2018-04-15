package com.wordpress.piedcipher.hobermanswitchpitchball;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    CardView playerGilfoyleCardView, playerRichardCardView, playerDineshCardView, playerErlichCardView, playerJaredCardView;
    boolean isPlayerGilfoyle, isPlayerRichard, isPlayerDinesh, isPlayerErlich, isPlayerJared;
    int currentSelectedPlayerCount;
    final int PLAYER_COUNT = 2;
    String[] players;
    int[] playerImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initializer();
    }

    private void initializer() {
        setTitle(R.string.title_activity_player);

        currentSelectedPlayerCount = 0;
        isPlayerGilfoyle = isPlayerRichard = isPlayerDinesh = isPlayerErlich = isPlayerJared = false;
        players = new String[2];
        playerImages = new int[2];

        playerGilfoyleCardView = findViewById(R.id.player_gilfoyle);
        playerRichardCardView = findViewById(R.id.player_richard);
        playerDineshCardView = findViewById(R.id.player_dinesh);
        playerErlichCardView = findViewById(R.id.player_erlich);
        playerJaredCardView = findViewById(R.id.player_jared);
    }

    public void onPlayerClick(View player) {
        if (currentSelectedPlayerCount == PLAYER_COUNT) {
            unselectPlayer(player);
            Toast.makeText(getApplicationContext(), "Please Select Only 2 Players!", Toast.LENGTH_SHORT).show();
        } else {
            selectPlayer(player);
        }
    }

    public void nextActivity(View nextButton) {
        if (currentSelectedPlayerCount == PLAYER_COUNT) {
            startActivity(new Intent(getApplicationContext(), SwitchPitchActivity.class)
                    .putExtra("PlayerOne", players[0])
                    .putExtra("PlayerTwo", players[1])
                    .putExtra("PlayerOneImage", playerImages[0])
                    .putExtra("PlayerTwoImage", playerImages[1])
            );
        } else {
            Toast.makeText(getApplicationContext(), "Select Any 2 Players to Proceed Next!", Toast.LENGTH_SHORT).show();
        }
    }

    public void previousActivity(View previousButton) {
        finish();
    }

    private void selectPlayer(View player) {
        switch (player.getId()) {
            case R.id.player_gilfoyle:
                if (!isPlayerGilfoyle) {
                    player.setBackgroundColor(Color.parseColor("#AED581"));
                    isPlayerGilfoyle = true;
                    players[currentSelectedPlayerCount] = "Gilfoyle";
                    playerImages[currentSelectedPlayerCount] = R.drawable.gilfoyle;
                    currentSelectedPlayerCount++;
                } else {
                    unselectPlayer(player);
                }
                break;
            case R.id.player_richard:
                if (!isPlayerRichard) {
                    player.setBackgroundColor(Color.parseColor("#AED581"));
                    isPlayerRichard = true;
                    players[currentSelectedPlayerCount] = "Richard";
                    playerImages[currentSelectedPlayerCount] = R.drawable.richard;
                    currentSelectedPlayerCount++;
                } else {
                    unselectPlayer(player);
                }
                break;
            case R.id.player_dinesh:
                if (!isPlayerDinesh) {
                    player.setBackgroundColor(Color.parseColor("#AED581"));
                    isPlayerDinesh = true;
                    players[currentSelectedPlayerCount] = "Dinesh";
                    playerImages[currentSelectedPlayerCount] = R.drawable.dinesh;
                    currentSelectedPlayerCount++;
                } else {
                    unselectPlayer(player);
                }
                break;
            case R.id.player_erlich:
                if (!isPlayerErlich) {
                    player.setBackgroundColor(Color.parseColor("#AED581"));
                    isPlayerErlich = true;
                    players[currentSelectedPlayerCount] = "Erlich";
                    playerImages[currentSelectedPlayerCount] = R.drawable.erlich;
                    currentSelectedPlayerCount++;
                } else {
                    unselectPlayer(player);
                }
                break;
            case R.id.player_jared:
                if (!isPlayerJared) {
                    player.setBackgroundColor(Color.parseColor("#AED581"));
                    isPlayerJared = true;
                    players[currentSelectedPlayerCount] = "Jared";
                    playerImages[currentSelectedPlayerCount] = R.drawable.jared;
                    currentSelectedPlayerCount++;
                } else {
                    unselectPlayer(player);
                }
                break;
        }
    }

    private void unselectPlayer(View player) {
        switch (player.getId()) {
            case R.id.player_gilfoyle:
                if (isPlayerGilfoyle) {
                    player.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isPlayerGilfoyle = false;
                    currentSelectedPlayerCount--;
                }
                break;
            case R.id.player_richard:
                if (isPlayerRichard) {
                    player.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isPlayerRichard = false;
                    currentSelectedPlayerCount--;
                }
                break;
            case R.id.player_dinesh:
                if (isPlayerDinesh) {
                    player.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isPlayerDinesh = false;
                    currentSelectedPlayerCount--;
                }
                break;
            case R.id.player_erlich:
                if (isPlayerErlich) {
                    player.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isPlayerErlich = false;
                    currentSelectedPlayerCount--;
                }
                break;
            case R.id.player_jared:
                if (isPlayerJared) {
                    player.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isPlayerJared = false;
                    currentSelectedPlayerCount--;
                }
                break;
        }
    }
}