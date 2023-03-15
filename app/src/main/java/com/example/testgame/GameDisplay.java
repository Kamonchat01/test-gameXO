package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    Spinner spinner;
    int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBtn = findViewById(R.id.play_again1);
        Button homeBtn = findViewById(R.id.home_button1);
        TextView playerTurn = findViewById(R.id.player_display);

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("Player_names");

        if (playerNames != null) {
            playerTurn.setText((playerNames[0] + " ' s Turn"));
        }



        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBtn, homeBtn, playerTurn, playerNames);

        spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (currentItem==position) {
                    return;  // do nothing
                }else {
                    Intent intent = new Intent(GameDisplay.this, GameDisplay2.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void playAgainButtonClick(View view) {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}