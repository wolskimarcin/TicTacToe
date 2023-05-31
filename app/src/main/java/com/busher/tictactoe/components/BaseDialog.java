package com.busher.tictactoe.components;

import android.app.Dialog;
import android.content.Context;

import com.busher.tictactoe.R;

public abstract class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        super(context, R.style.RoundedCornersDialog);
    }

    protected abstract void initializeViews();

    protected abstract void setupListeners();

}
