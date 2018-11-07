package com.dexfun.yiku.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.TextView;

import com.dexfun.yiku.R;


/**
 * Created by Smile on 17/6/5.
 */

public class BaseDialog extends Dialog implements DialogInterface {

    private TextView T, N, Y;
    private boolean hasBtn = true;
    private Context mContext;
    private CharSequence mTitle;
    private CharSequence mMessage;
    private CharSequence mPositiveButtonText;
    private CharSequence mNegativeButtonText;
    private OnClickListener mPositiveButtonListener;
    private OnClickListener mNegativeButtonListener;


    public static final int COMPLETE = 0;

    public BaseDialog(@NonNull Context context, boolean hasBtn) {
        super(context, R.style.dialog);
        this.mContext = context;
        this.hasBtn = hasBtn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasBtn) setContentView(R.layout.dialog_base_layout);
        else setContentView(R.layout.dialog_base_layout_t);
        initView();
    }

    private void initView() {
        T = findViewById(R.id.base_dialog_t);
        N = findViewById(R.id.base_dialog_n_t);
        Y = findViewById(R.id.base_dialog_y_t);
        T.setText(mMessage);
        N.setText(mNegativeButtonText);
        Y.setText(mPositiveButtonText);
        findViewById(R.id.base_dialog_n).setOnClickListener(
                v -> mNegativeButtonListener.onClick(BaseDialog.this, 0));
        findViewById(R.id.base_dialog_y).setOnClickListener(
                v -> mPositiveButtonListener.onClick(BaseDialog.this, 0));
    }

    public BaseDialog setText(@Nullable CharSequence title) {
        this.mTitle = title;
        return this;
    }


    public BaseDialog setCancel(boolean flag) {
        setCancelable(flag);
        return this;
    }

    public BaseDialog setText(int titleId) {
        this.mTitle = this.mContext.getText(titleId);
        return this;
    }

    public BaseDialog setMessage(@StringRes int messageId) {
        this.mMessage = this.mContext.getText(messageId);
        return this;
    }

    public BaseDialog setMessage(@NonNull CharSequence message) {
        this.mMessage = message;
        return this;
    }

    public BaseDialog setPositiveButton(@StringRes int textId, @NonNull OnClickListener listener) {
        this.mPositiveButtonText = this.mContext.getText(textId);
        this.mPositiveButtonListener = listener;
        return this;
    }

    public BaseDialog setPositiveButton(CharSequence text, @NonNull OnClickListener listener) {
        this.mPositiveButtonText = text;
        this.mPositiveButtonListener = listener;
        return this;
    }

    public BaseDialog setNegativeButton(@StringRes int textId, @NonNull OnClickListener listener) {
        this.mNegativeButtonText = this.mContext.getText(textId);
        this.mNegativeButtonListener = listener;
        return this;
    }

    public BaseDialog setNegativeButton(CharSequence text, @NonNull OnClickListener listener) {
        this.mNegativeButtonText = text;
        this.mNegativeButtonListener = listener;
        return this;
    }
}
