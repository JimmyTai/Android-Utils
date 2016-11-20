package com.jimmytai.library.utils.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public abstract class JDialogFragment extends DialogFragment {

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JLog.i(setDebug(), setTag(), "onCreate()");
        this.jLifeCycle = JLifecycle.ON_CREATE;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        JLog.i(setDebug(), setTag(), "onCreateDialog()");
        this.jLifeCycle = JLifecycle.ON_CREATE_DIALOG;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE_DIALOG);
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
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
}
