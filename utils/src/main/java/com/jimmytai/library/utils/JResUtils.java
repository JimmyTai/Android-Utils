package com.jimmytai.library.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * Created by JimmyTai on 2016/11/19.
 * <p>
 * This JResUtils provides a easy way to get resource file in xml.
 */

public class JResUtils {

    public static int getColor(Context context, int id) {
        if (Build.VERSION.SDK_INT < 23)
            return context.getResources().getColor(id);
        else
            return context.getColor(id);
    }

    public static int getColor(Context context, int id, Resources.Theme style) {
        if (Build.VERSION.SDK_INT < 23)
            return context.getResources().getColor(id);
        else
            return context.getResources().getColor(id, style);
    }

    public static String getString(Context context, int id) {
        return context.getResources().getString(id);
    }

    public static Drawable getDrawable(Context context, int id) {
        if (Build.VERSION.SDK_INT < 23)
            return context.getResources().getDrawable(id);
        else
            return context.getDrawable(id);
    }

    public static Drawable getDrawable(Context context, int id, Resources.Theme style) {
        if (Build.VERSION.SDK_INT < 23)
            return context.getResources().getDrawable(id);
        else
            return context.getResources().getDrawable(id, style);
    }
}
