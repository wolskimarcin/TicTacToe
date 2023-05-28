package com.busher.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerSelectionActivity extends AppCompatActivity {

    private EditText editTextPlayer1;
    private EditText editTextPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);

        editTextPlayer1 = findViewById(R.id.editTextPlayer1);
        editTextPlayer2 = findViewById(R.id.editTextPlayer2);
        Button buttonStartGame = findViewById(R.id.buttonStartGame);

        buttonStartGame.setOnClickListener(v -> startGame());
    }

    private void startGame() {
        String player1Name = editTextPlayer1.getText().toString();
        String player2Name = editTextPlayer2.getText().toString();

        Intent intent = new Intent(PlayerSelectionActivity.this, TicTacToeActivity.class);
        intent.putExtra("player1", player1Name);
        intent.putExtra("player2", player2Name);
        startActivity(intent);
    }
}
