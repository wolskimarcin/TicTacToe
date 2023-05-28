package com.busher.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {
    private final Button[][] board = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private String player1Name;
    private String player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        TextView textViewPlayer1 = findViewById(R.id.text_view_player1);
        TextView textViewPlayer2 = findViewById(R.id.text_view_player2);
        GridLayout grid_buttons = findViewById(R.id.grid_buttons);

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (Button) grid_buttons.getChildAt(idx);
                board[i][j].setOnClickListener(this);
                idx++;
            }
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            player1Name = extras.getString("player1");
            player2Name = extras.getString("player2");
            textViewPlayer1.setText(player1Name);
            textViewPlayer2.setText(player2Name);
        }
    }

    @Override
    public void onClick(View v) {
        String resourceName = this.getResources().getResourceName(v.getId());
        Log.d("ON_FIELD_CLICK", resourceName);

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                win(1);
            } else {
                win(2);
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private void win(int playerNum) {
        if (playerNum == 1) {
            Toast.makeText(this, player1Name + " wins!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, player2Name + " wins!", Toast.LENGTH_SHORT).show();
        }
        onBackPressed();
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = board[i][j].getText().toString();
            }
        }

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].isEmpty()) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].isEmpty()) {
                return true;
            }
        }

        // Check diagonals
        if ((field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].isEmpty())
                || (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].isEmpty())) {
            return true;
        }

        return false; // No winner yet
    }

    private void draw() {
        onBackPressed();
    }
}