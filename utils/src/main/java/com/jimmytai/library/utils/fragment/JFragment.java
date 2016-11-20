package com.jimmytai.library.utils.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * This JActivity class is extends from Support Fragment.
 * It provides a lifecycle listener to watch the lifecycle of Fragment.
 */

public abstract class JFragment extends Fragment {

    public View jView;
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jLifeCycle = JLifecycle.ON_ATTACH;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_ATTACH);
        JLog.i(setDebug(), setTag(), "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.jLifeCycle = JLifecycle.ON_CREATE;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE);
        JLog.i(setDebug(), setTag(), "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.jLifeCycle = JLifecycle.ON_CREATE_VIEW;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE_VIEW);
        JLog.i(setDebug(), setTag(), "onCreateView()");
        jView = inflater.inflate(setLayout(), container, false);
        return jView;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.jLifeCycle = JLifecycle.ON_START;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_START);
        JLog.i(setDebug(), setTag(), "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        this.jLifeCycle = JLifecycle.ON_RESUME;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_RESUME);
        JLog.i(setDebug(), setTag(), "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        this.jLifeCycle = JLifecycle.ON_PAUSE;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_PAUSE);
        JLog.i(setDebug(), setTag(), "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        this.jLifeCycle = JLifecycle.ON_STOP;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_STOP);
        JLog.i(setDebug(), setTag(), "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.jLifeCycle = JLifecycle.ON_DESTROY_VIEW;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_DESTROY_VIEW);
        JLog.i(setDebug(), setTag(), "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.jLifeCycle = JLifecycle.ON_DESTROY;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_DESTROY);
        JLog.i(setDebug(), setTag(), "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.jLifeCycle = JLifecycle.ON_DETACH;
        for (int i = 0; i < lifeCycleListenerList.size(); i++)
            lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_DETACH);
        JLog.i(setDebug(), setTag(), "onDetach()");
    }
}
