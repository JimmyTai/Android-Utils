package com.jimmytai.library.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by JimmyTai on 2016/11/19.
 * <p>
 * This JScreenUtils class provides a lot of utilities function for screen such as screen size or dimension translate.
 */

public class JScreenUtils {

    /**
     * Transfer unit sp to pixel
     *
     * @param sp The value of unit sp.
     * @return Pixel value.
     */
    public static float sp2px(Context context, float sp) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return sp * fontScale + 0.5f;
    }

    /**
     * Transfer unit pixel to sp
     *
     * @param px The value of px.
     * @return sp value.
     */
    public static float px2sp(Context context, float px) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return px / fontScale + 0.5f;
    }

    /**
     * Transfer unit dp to pixel.
     *
     * @param dp The value of dp.
     * @return Pixel value
     */
    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    /**
     * Transfer unit pixel to dp.
     *
     * @param px The value of pixel.
     * @return dp value.
     */
    public static float px2dip(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return px / scale + 0.5f;
    }

    /**
     * Get screen width.
     *
     * @return Pixel value of screen width.
     */
    public static int getWidth(Context context) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    /**
     * Get screen height.
     *
     * @return Pixel value of screen height.
     */
    public static int getHeight(Context context) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    /**
     * Get screen density.
     *
     * @return float value of screen density.
     */
    public static float getDensity(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /**
     * The screen density expressed as dots-per-inch. May be either DENSITY_LOW, DENSITY_MEDIUM, or DENSITY_HIGH.
     *
     * @return int value of device resource density.
     */
    public static int getDeviceResourceDensity(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }
}
