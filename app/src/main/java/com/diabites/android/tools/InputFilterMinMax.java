package com.diabites.android.tools;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

public class InputFilterMinMax implements InputFilter {
    private static final String TAG = "InputFilterMinMax";

    private double min, max;

    public InputFilterMinMax(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = ReadingTools.safeParseDouble(min);
        this.max = ReadingTools.safeParseDouble(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            double input = ReadingTools.safeParseDouble(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "filter: ", nfe);
        }
        return "";
    }

    protected boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
