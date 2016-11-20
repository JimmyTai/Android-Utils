package com.jimmytai.library.utils.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jimmytai.library.utils.lifecycle.JLifecycle;
import com.jimmytai.library.utils.log.JLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JimmyTai on 2016/11/17.
 * <p>
 * This JActivity class is extends from Activity.
 * It provides a lifecycle listener to watch the lifecycle of Activity.
 */

public abstract class JActivity extends Activity {

    public JActivity jActivity;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.jActivity = this;
        this.jLifeCycle = JLifecycle.ON_CREATE;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_CREATE);
        JLog.i(setDebug(), setTag(), "onCreate()");
        setContentView(setLayout());
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.jLifeCycle = JLifecycle.ON_START;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_START);
        JLog.i(setDebug(), setTag(), "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.jLifeCycle = JLifecycle.ON_RESTART;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_RESTART);
        JLog.i(setDebug(), setTag(), "onRestart()");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.jLifeCycle = JLifecycle.ON_USER_LEAVE_HINT;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_USER_LEAVE_HINT);
        JLog.i(setDebug(), setTag(), "onUserLeaveHint()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.jLifeCycle = JLifecycle.ON_RESUME;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_RESUME);
        JLog.i(setDebug(), setTag(), "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.jLifeCycle = JLifecycle.ON_PAUSE;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_PAUSE);
        JLog.i(setDebug(), setTag(), "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.jLifeCycle = JLifecycle.ON_STOP;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_STOP);
        JLog.i(setDebug(), setTag(), "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.jLifeCycle = JLifecycle.ON_DESTROY;
        for (int i = 0; i < this.lifeCycleListenerList.size(); i++)
            this.lifeCycleListenerList.get(i).onLifecycleChanged(JLifecycle.ON_DESTROY);
        JLog.i(setDebug(), setTag(), "onDestroy()");
        this.jActivity = null;
        removeLifeCycleListener();
    }
}