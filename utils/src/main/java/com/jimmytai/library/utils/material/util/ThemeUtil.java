package com.jimmytai.library.utils.material.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.TypedValue;

public class ThemeUtil {

    private static TypedValue value;

    private static int getColor(Context context, int id, int defaultValue) {
        if (value == null)
            value = new TypedValue();

        try {
            Theme theme = context.getTheme();
            if (theme != null && theme.resolveAttribute(id, value, true)) {
                if (value.type >= TypedValue.TYPE_FIRST_INT && value.type <= TypedValue.TYPE_LAST_INT)
                    return value.data;
                else if (value.type == TypedValue.TYPE_STRING)
                    return context.getResources().getColor(value.resourceId);
            }
        } catch (Exception ex) {
        }

        return defaultValue;
    }

    public static int windowBackground(Context context, int defaultValue) {
        return getColor(context, android.R.attr.windowBackground, defaultValue);
    }

    public static int textColorPrimary(Context context, int defaultValue) {
        return getColor(context, android.R.attr.textColorPrimary, defaultValue);
    }

    public static int textColorSecondary(Context context, int defaultValue) {
        return getColor(context, android.R.attr.textColorSecondary, defaultValue);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorPrimary(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorPrimary, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorPrimaryDark(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorPrimaryDark, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorAccent(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorAccent, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorControlNormal(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorControlNormal, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorControlActivated(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorControlActivated, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorControlHighlight(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorControlHighlight, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorButtonNormal(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorButtonNormal, defaultValue);
        return defaultValue;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorSwitchThumbNormal(Context context, int defaultValue) {
        if (Build.VERSION.SDK_INT >= 21)
            return getColor(context, android.R.attr.colorAccent, defaultValue);
        return defaultValue;
    }

    public static int getType(TypedArray array, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return array.getType(index);
        else {
            TypedValue value = array.peekValue(index);
            return value == null ? TypedValue.TYPE_NULL : value.type;
        }
    }

    public static CharSequence getString(TypedArray array, int index, CharSequence defaultValue) {
        String result = array.getString(index);
        return result == null ? defaultValue : result;
    }

}
