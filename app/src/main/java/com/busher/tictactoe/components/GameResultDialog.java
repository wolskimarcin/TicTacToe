package com.busher.tictactoe.components;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.busher.tictactoe.R;

public abstract class GameResultDialog extends BaseDialog {

    private final String announcement;
    private Button restartButton;
    private Button exitButton;

    public GameResultDialog(Context context, String announcement) {
        super(context);
        this.announcement = announcement;
        setCancelable(false);
        setContentView(R.layout.dialog_game_result);
        initializeViews();
        setupListeners();
    }

    @Override
    protected void initializeViews() {
        TextView winnerTextView = findViewById(R.id.text_view_winner);
        restartButton = findViewById(R.id.button_restart);
        exitButton = findViewById(R.id.button_exit);

        winnerTextView.setText(announcement);
    }

    @Override
    protected void setupListeners() {
        restartButton.setOnClickListener(v -> {
            dismiss();
            onCallback(false);
        });

        exitButton.setOnClickListener(v -> {
            dismiss();
            onCallback(true);
        });
    }

    protected abstract void onCallback(boolean isExit);

}
