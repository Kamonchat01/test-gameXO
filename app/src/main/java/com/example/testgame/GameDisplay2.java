package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay2 extends AppCompatActivity {
    private TicTacToeBoard2 ticTacToeBoard2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display2);

        String[] playerNames = getIntent().getStringArrayExtra("Player_names");

        Button playAgainBTN = findViewById(R.id.play_again2);
        Button historyBTN = findViewById(R.id.home_button2);
        TextView playerTurn = findViewById(R.id.player_display);

        ticTacToeBoard2 = findViewById(R.id.ticTacToeBoard);

       // ticTacToeBoard2.setUpGame(playAgainBTN, historyBTN, playerTurn, playerNames);
    }

    public void playAgainButtonClick(View view){
        //ticTacToeBoard2.resetGame();
        ticTacToeBoard2.invalidate();
    }
    public void historyButtonClick(View view){
        Intent intent = new Intent(GameDisplay2.this, HistoryPlay.class);
        startActivity(intent);
    }

}