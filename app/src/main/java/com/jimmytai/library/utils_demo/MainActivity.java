package com.jimmytai.library.utils_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jimmytai.library.utils.JResUtils;
import com.jimmytai.library.utils.activity.JActivity;
import com.jimmytai.library.utils.custom_view.ViewExpandCollapse;
import com.jimmytai.library.utils.dialog.JLoadingDialog;

public class MainActivity extends JActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
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
        findViews();
        JLoadingDialog dialog = JLoadingDialog.newInstance(JResUtils.getColor(this, R.color.colorPrimary), true);
        dialog.show(getFragmentManager(), JLoadingDialog.class.getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /* --- Listener --- */

    private MyClickListener myClickListener = new MyClickListener();

    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.equals(tv_expand)) {
                ViewExpandCollapse.expand(jActivity, rl_expandCollapse, 300, 200, myExpandCollapseCallback);
            } else if (v.equals(tv_collapse)) {
                ViewExpandCollapse.collapse(jActivity, rl_expandCollapse, 60, 200, myExpandCollapseCallback);
            }
        }
    }

    private MyExpandCollapseCallback myExpandCollapseCallback = new MyExpandCollapseCallback();

    private class MyExpandCollapseCallback implements ViewExpandCollapse.OnChangeListener {

        @Override
        public void onInit(ViewExpandCollapse.Type type) {

        }

        @Override
        public void onStart(ViewExpandCollapse.Type type) {

        }

        @Override
        public void onFinish(ViewExpandCollapse.Type type) {

        }
    }

    /* --- Views --- */

    private RelativeLayout rl_container, rl_expandCollapse;
    private TextView tv_expand, tv_collapse;

    private void findViews() {
        rl_container = (RelativeLayout) findViewById(R.id.main_rl_container);
        rl_expandCollapse = (RelativeLayout) findViewById(R.id.main_rl_expandCollapse);
        tv_expand = (TextView) findViewById(R.id.main_tv_expand);
        tv_expand.setOnClickListener(myClickListener);
        tv_collapse = (TextView) findViewById(R.id.main_tv_collapse);
        tv_collapse.setOnClickListener(myClickListener);
    }
}
