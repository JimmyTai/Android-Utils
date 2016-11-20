package com.jimmytai.library.utils.lifecycle;

/**
 * Created by JimmyTai on 2016/11/18.
 */

public enum JLifecycle {
    NOT_INITIAL, ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_USER_LEAVE_HINT, ON_RESTART, ON_ATTACH,
    ON_CREATE_VIEW, ON_DESTROY_VIEW, ON_DETACH, ON_CREATE_DIALOG;

    public interface LifecycleListener {
        void onLifecycleChanged(JLifecycle lifecycle);
    }
}
