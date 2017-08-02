package com.jimmytai.library.utils.view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

import com.jimmytai.library.utils.JScreenUtils;

/**
 * Created by JimmyTai on 2017/8/2.
 */

public class ViewExpandCollapse {

    public enum Type {
        EXPAND, COLLAPSE
    }

    public interface OnChangeListener {
        void onInit(Type type);

        void onStart(Type type);

        void onFinish(Type type);
    }

    public static void expand(Context context, final View v, int targetHeight, int duration, final OnChangeListener listener) {
        if (listener != null)
            listener.onInit(Type.EXPAND);
        final int initialHeight = v.getMeasuredHeight();
        final int distance = (int) JScreenUtils.dp2px(context, targetHeight) - initialHeight;
        Animation a = new Animation() {

            @Override
            public void initialize(int width, int height, int parentWidth, int parentHeight) {
                super.initialize(width, height, parentWidth, parentHeight);
                if (listener != null) {
                    listener.onStart(Type.EXPAND);
                }
            }

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    if (listener != null) {
                        listener.onFinish(Type.EXPAND);
                    }
                } else {
                    v.getLayoutParams().height = initialHeight + (int) (distance * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(duration);
        a.setInterpolator(new DecelerateInterpolator());
        v.startAnimation(a);
    }

    public static void collapse(Context context, final View v, int targetHeight, int duration, final OnChangeListener listener) {
        if (listener != null)
            listener.onInit(Type.COLLAPSE);
        final int initialHeight = v.getMeasuredHeight();
        final int distance = initialHeight - ((int) JScreenUtils.dp2px(context, targetHeight));
        Animation a = new Animation() {
            @Override
            public void initialize(int width, int height, int parentWidth, int parentHeight) {
                super.initialize(width, height, parentWidth, parentHeight);
                if (listener != null)
                    listener.onStart(Type.COLLAPSE);
            }

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    if (listener != null)
                        listener.onFinish(Type.COLLAPSE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (distance * interpolatedTime);
                    v.requestLayout();
                }
            }
        };

        a.setDuration(duration);
        a.setInterpolator(new DecelerateInterpolator());
        v.startAnimation(a);
    }
}
