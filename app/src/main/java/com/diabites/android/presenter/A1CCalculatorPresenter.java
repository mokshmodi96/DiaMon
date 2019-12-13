
package com.diabites.android.presenter;

import android.support.annotation.NonNull;

import com.diabites.android.Constants;
import com.diabites.android.activity.A1cCalculatorActivity;
import com.diabites.android.db.DatabaseHandler;
import com.diabites.android.db.HB1ACReading;
import com.diabites.android.db.User;
import com.diabites.android.tools.GlucosioConverter;
import com.diabites.android.tools.ReadingTools;



import java.util.Date;

public class A1CCalculatorPresenter {
    private final DatabaseHandler dbHandler;
    private final A1cCalculatorActivity activity;

    public A1CCalculatorPresenter(@NonNull final A1cCalculatorActivity activity,
                                  @NonNull final DatabaseHandler dbHandler) {
        this.activity = activity;
        this.dbHandler = dbHandler;
    }

    public double calculateA1C(String glucose) {
        if (isInvalidDouble(glucose)) {
            return 0;
        }

        double convertedA1C;
        User user = dbHandler.getUser(1);

        double glucoseDouble = ReadingTools.safeParseDouble(glucose);
        if (Constants.Units.MG_DL.equals(user.getPreferred_unit())) {
            convertedA1C = GlucosioConverter.glucoseToA1C(glucoseDouble);
        } else {
            convertedA1C = GlucosioConverter.glucoseToA1C(GlucosioConverter.glucoseToMgDl(glucoseDouble));
        }
        if ("percentage".equals(user.getPreferred_unit_a1c())) {
            return convertedA1C;
        } else {
            return GlucosioConverter.a1cNgspToIfcc(convertedA1C);
        }
    }

    private boolean isInvalidDouble(String value) {
        return value == null || value.length() == 0 || (value.length() == 1 && !Character.isDigit(value.charAt(0)));
    }

    public void checkGlucoseUnit() {
        if (!Constants.Units.MG_DL.equals(dbHandler.getUser(1).getPreferred_unit())) {
            activity.setMmol();
        }
    }

    public void saveA1C(double a1c) {
        User user = dbHandler.getUser(1);
        double finalA1c = a1c;
        if (!"percentage".equals(user.getPreferred_unit_a1c())) {
            finalA1c = GlucosioConverter.a1cIfccToNgsp(a1c);
        }

        HB1ACReading a1cReading = new HB1ACReading(finalA1c, new Date());
        dbHandler.addHB1ACReading(a1cReading);
        activity.finish();
    }

    public String getA1cUnit() {
        return dbHandler.getUser(1).getPreferred_unit_a1c();
    }

}
