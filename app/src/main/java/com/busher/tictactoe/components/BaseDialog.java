package com.busher.tictactoe.components;

import android.app.Dialog;
import android.content.Context;

public abstract class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        super(context);
    }

    protected abstract void initializeViews();

    protected abstract void setupListeners();

}
