package com.diabites.android.presenter;

import com.diabites.android.activity.AddWeightActivity;
import com.diabites.android.db.DatabaseHandler;
import com.diabites.android.db.WeightReading;
import com.diabites.android.tools.GlucosioConverter;
import com.diabites.android.tools.ReadingTools;



import java.util.Date;

public class AddWeightPresenter extends AddReadingPresenter {
    private DatabaseHandler dB;
    private AddWeightActivity activity;


    public AddWeightPresenter(AddWeightActivity addWeightActivity) {
        this.activity = addWeightActivity;
        dB = new DatabaseHandler(addWeightActivity.getApplicationContext());
    }

    public void dialogOnAddButtonPressed(String time, String date, String reading) {
        if (validateDate(date) && validateTime(time) && validateWeight(reading)) {

            WeightReading wReading = generateWeightReading(reading);
            dB.addWeightReading(wReading);

            activity.finishActivity();
        } else {
            activity.showErrorMessage();
        }
    }

    public void dialogOnAddButtonPressed(String time, String date, String reading, long oldId) {
        if (validateDate(date) && validateTime(time) && validateWeight(reading)) {

            WeightReading wReading = generateWeightReading(reading);
            dB.editWeightReading(oldId, wReading);

            activity.finishActivity();
        } else {
            activity.showErrorMessage();
        }
    }

    private WeightReading generateWeightReading(String reading) {
        Date finalDateTime = getReadingTime();

        double finalReading;

        if ("kilograms".equals(getWeightUnitMeasuerement())) {
            finalReading = ReadingTools.safeParseDouble(reading);
        } else {
            finalReading = GlucosioConverter.lbToKg(ReadingTools.safeParseDouble(reading));
        }

        return new WeightReading(finalReading, finalDateTime);
    }

    // Getters and Setters

    public String getWeightUnitMeasuerement() {
        return dB.getUser(1).getPreferred_unit_weight();
    }

    public WeightReading getWeightReadingById(Long id) {
        return dB.getWeightReadingById(id);
    }

    // Validator
    private boolean validateWeight(String reading) {
        return validateText(reading);
    }

}
