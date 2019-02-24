package com.jimmytai.library.utils.dialog;

import android.app.Dialog;
import android.os.Bundle;

import com.jimmytai.library.utils.R;
import com.jimmytai.library.utils.material.ProgressView;
import com.jimmytai.library.utils.material.drawable.CircularProgressDrawable;

/**
 * Created by JimmyTai on 2017/8/15.
 */

public class JLoadingDialog extends JDialog {

    @Override
    public String setTag() {
        return JLoadingDialog.class.getSimpleName();
    }

    @Override
    public boolean setDebug() {
        return false;
    }

    @Override
    public int setLayout() {
        return R.layout.utils_jdialog_loading;
    }

    public static JLoadingDialog newInstance(int color, boolean isDim) {

        Bundle args = new Bundle();
        args.putInt("color", color);
        args.putBoolean("isDim", isDim);

        JLoadingDialog fragment = new JLoadingDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        jDialog.setCanceledOnTouchOutside(false);
        int color = getArguments().getInt("color");
        boolean isDim = getArguments().getBoolean("isDim");
        setDim(isDim);
        ProgressView progressView = jView.findViewById(R.id.jDialogLoading_progress);
        ((CircularProgressDrawable) progressView.getBackground()).setStrokeColor(color);
        return jDialog;
    }
}
