package com.jimmytai.library.utils.anim;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

import com.jimmytai.library.utils.JScreenUtils;

/**
 * Created by JimmyTai on 2017/4/18.
 */

public class ResizeWidthAnimation extends Animation {

    private View view;
    private int newWidth, oldWidth;

    public interface OnResizeListener {
        void onStart();

        void onResize(int width);

        void onEnd();
    }

    private OnResizeListener listener;

    public void setOnResizeListener(OnResizeListener listener) {
        this.listener = listener;
    }

    public ResizeWidthAnimation(View view, int newWidth) {
        this.view = view;
        this.newWidth = newWidth;
        this.oldWidth = view.getWidth();
        AnimationListener animationListener = new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (listener != null)
                    listener.onStart();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (listener != null)
                    listener.onEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
        this.setAnimationListener(animationListener);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        int w = oldWidth + (int) ((newWidth - oldWidth) * interpolatedTime);
        view.getLayoutParams().width = w;
        if (listener != null)
            listener.onResize(w);
        view.requestLayout();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}
