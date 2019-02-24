package com.jimmytai.library.utils.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jimmytai.library.utils.R;
import com.jimmytai.library.utils.lifecycle.JLifecycle;
import com.jimmytai.library.utils.log.JLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JimmyTai on 2016/11/18.
 * <p>
 * This JActivity class is extends from Support DialogFragment.
 * It provides a lifecycle listener to watch the lifecycle of DialogFragment.
 */

public abstract class JDialog extends DialogFragment {

    public JLifecycle jLifeCycle = JLifecycle.NOT_INITIAL;
    private List<JLifecycle.LifecycleListener> lifeCycleListenerList = new ArrayList<>();

    public void addLifeCycleListener(JLifecycle.LifecycleListener listener) {
        this.lifeCycleListenerList.add(listener);
    }

    public void removeLifeCyclieListner(JLifecycle.LifecycleListener listener) {
        this.lifeCycleListenerList.remove(listener);
    }

    public void removeLifeCycleListener() {
        this.lifeCycleListenerList.clear();
    }

    public abstract String setTag();

    public abstract boolean setDebug();

    public abstract int setLayout();

    public interface OnDismissListener {
        void onDismiss(DialogInterface dialog);
    }

    private OnDismissListener onDismissListener;

    public void setOnDismissListener(OnDismissListener listener) {
        this.onDismissListener = listener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        JLog.i(setDebug(), setTag(), "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JLog.i(setDebug(), setTag(), "onCreate()");
        this.jLifeCycle = JLifecycle.ON_CREATE;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE);
    }

    public Dialog jDialog;
    public View jView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        JLog.i(setDebug(), setTag(), "onCreateDialog()");
        this.jLifeCycle = JLifecycle.ON_CREATE_DIALOG;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE_DIALOG);
        jDialog = new Dialog(getActivity(), R.style.JDialog);
        jView = LayoutInflater.from(getActivity()).inflate(setLayout(), null, false);
        jDialog.setContentView(jView);
        return super.onCreateDialog(savedInstanceState);
    }

    public void setDim(boolean isDim) {
        Window window = jDialog.getWindow();
        if (window == null)
            return;
        if (!isDim)
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        else
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public void setWindows(int gravity, int width, int height) {
        Window window = jDialog.getWindow();
        if (window == null)
            return;
        window.setGravity(gravity);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = width;
        params.height = height;
        window.setAttributes(params);
    }

    public void setWindowPadding(int left, int top, int right, int bottom) {
        Window window = jDialog.getWindow();
        if (window == null)
            return;
        window.getDecorView().setPadding(left, top, right, bottom);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        JLog.i(setDebug(), setTag(), "onCreateView()");
        this.jLifeCycle = JLifecycle.ON_CREATE_VIEW;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE_VIEW);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        JLog.i(setDebug(), setTag(), "onStart()");
        this.jLifeCycle = JLifecycle.ON_START;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_START);
    }

    @Override
    public void onResume() {
        super.onResume();
        JLog.i(setDebug(), setTag(), "onResume()");
        this.jLifeCycle = JLifecycle.ON_RESUME;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_RESUME);
    }

    @Override
    public void onPause() {
        super.onPause();
        JLog.i(setDebug(), setTag(), "onPause()");
        this.jLifeCycle = JLifecycle.ON_PAUSE;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_PAUSE);
    }

    @Override
    public void onStop() {
        super.onStop();
        JLog.i(setDebug(), setTag(), "onStop()");
        this.jLifeCycle = JLifecycle.ON_STOP;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_STOP);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        JLog.i(setDebug(), setTag(), "onDestroyView()");
        this.jLifeCycle = JLifecycle.ON_DESTROY_VIEW;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_DESTROY_VIEW);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        JLog.i(setDebug(), setTag(), "onDestroy()");
        this.jLifeCycle = JLifecycle.ON_DESTROY;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_DESTROY);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        JLog.i(setDebug(), setTag(), "onDetach()");
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null)
            onDismissListener.onDismiss(dialog);
    }
}
