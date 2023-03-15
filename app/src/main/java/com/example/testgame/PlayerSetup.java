package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.testgame.dp.AppDatabase;
import com.example.testgame.dp.User;

public class PlayerSetup extends AppCompatActivity {

    Button saveBtn;
    private EditText player1;
    private EditText player2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        saveBtn = findViewById(R.id.save_btn);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser(player1.getText(). toString(), player2.getText().toString());
            }
        });

    }

    private void saveUser(String player1, String player2) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.player1 = player1;
        user.player2 = player2;
        db.userDao().insertUser(user);

        finish();
    }

    public void submitButtonClick(View view) {
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("Player_names", new String[] {player1Name, player2Name});
        startActivity(intent);
    }

    public void saveButtonClick(View view) {
        Intent intent = new Intent(this, HistoryPlay.class);
    }

}