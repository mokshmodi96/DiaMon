package com.diabites.android.presenter;

import com.diabites.android.activity.AddKetoneActivity;
import com.diabites.android.db.DatabaseHandler;
import com.diabites.android.db.KetoneReading;
import com.diabites.android.tools.ReadingTools;



import java.util.Date;

public class AddKetonePresenter extends AddReadingPresenter {
    private DatabaseHandler dB;
    private AddKetoneActivity activity;

    public AddKetonePresenter(AddKetoneActivity addKetoneActivity) {
        this.activity = addKetoneActivity;
        dB = new DatabaseHandler(addKetoneActivity.getApplicationContext());
    }

    public void dialogOnAddButtonPressed(String time, String date, String reading) {
        if (validateDate(date) && validateTime(time) && validateKetone(reading)) {

            KetoneReading kReading = generateKetoneReading(reading);
            dB.addKetoneReading(kReading);

            activity.finishActivity();
        } else {
            activity.showErrorMessage();
        }
    }

    public void dialogOnAddButtonPressed(String time, String date, String reading, long oldId) {
        if (validateDate(date) && validateTime(time) && validateText(reading)) {

            KetoneReading kReading = generateKetoneReading(reading);
            dB.editKetoneReading(oldId, kReading);

            activity.finishActivity();
        } else {
            activity.showErrorMessage();
        }
    }

    private KetoneReading generateKetoneReading(String reading) {
        Date finalDateTime = getReadingTime();
        double finalReading = ReadingTools.safeParseDouble(reading);
        return new KetoneReading(finalReading, finalDateTime);
    }

    public String getUnitMeasuerement() {
        return dB.getUser(1).getPreferred_unit();
    }

    public KetoneReading getKetoneReadingById(Long id) {
        return dB.getKetoneReadingById(id);
    }

    // Validator
    private boolean validateKetone(String reading) {
        return validateText(reading);
    }
}
