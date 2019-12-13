package com.diabites.android.tools;

import android.support.annotation.Nullable;

import java.text.NumberFormat;
import java.text.ParseException;

public class ReadingTools {

    public ReadingTools() {
    }

    public int hourToSpinnerType(int hour) {

        if (hour > 23) {
            return 8;  //night
        } else if (hour > 20) {
            return 5; //after dinner
        } else if (hour > 17) {
            return 4; // before dinner
        } else if (hour > 13) {
            return 3; // after lunch
        } else if (hour > 11) {
            return 2; // before lunch
        } else if (hour > 7) {
            return 1; //after breakfast
        } else if (hour > 4) {
            return 0; // before breakfast
        } else {
            return 8; // night time
        }
    }

    /**
     * A convenient method for parsing reading value based on user's locale
     *
     * @param reading reading number String
     * @return reading Number
     */
    @Nullable
    public static Number parseReading(String reading) {
        if (reading == null)
            return null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        try {
            return numberFormat.parse(reading);
        } catch (ParseException e) {
            return null;
        }
    }

    public static double safeParseDouble(String doubleValue) {
        try {
            return NumberFormat.getInstance().parse(doubleValue).doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
