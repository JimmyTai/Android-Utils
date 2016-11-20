package com.jimmytai.library.utils_demo;

import android.os.Bundle;

import com.jimmytai.library.utils.activity.JActivity;

public class MainActivity extends JActivity {

    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = false;

    @Override
    public String setTag() {
        return TAG;
    }

    @Override
    public boolean setDebug() {
        return DEBUG;
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
