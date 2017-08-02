package com.jimmytai.library.utils.font;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/**
 * Created by JimmyTai on 2017/8/2.
 */

public class CustomTypefaceSpan extends TypefaceSpan {

    private final Typeface typeface;
    private int size;
    private int color;

    public CustomTypefaceSpan(String family, Typeface typeface, int size, int color) {
        super(family);
        this.typeface = typeface;
        this.size = size;
        this.color = color;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeface(ds, typeface, size, color);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeface(paint, typeface, size, color);
    }

    private static void applyCustomTypeface(Paint paint, Typeface typeface, int size, int color) {
        paint.setColor(color);
        int oldStyle = paint.getTypeface() == null ? 0 : paint.getTypeface().getStyle();
        int fake = oldStyle & ~typeface.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
        paint.setTextSize(size);
    }
}
