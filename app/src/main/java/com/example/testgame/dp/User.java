package com.example.testgame.dp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int number;

    @ColumnInfo(name = "Player_one")
    public String player1;

    @ColumnInfo(name = "Player_two")
    public String player2;
}
