package com.diabites.android.presenter;

import com.diabites.android.activity.AddCholesterolActivity;
import com.diabites.android.db.CholesterolReading;
import com.diabites.android.db.DatabaseHandler;
import com.diabites.android.tools.ReadingTools;


import java.util.Date;

public class AddCholesterolPresenter extends AddReadingPresenter {
    private DatabaseHandler dB;
    private AddCholesterolActivity activity;

    public AddCholesterolPresenter(AddCholesterolActivity addCholesterolActivity) {
        this.activity = addCholesterolActivity;
        dB = new DatabaseHandler(addCholesterolActivity.getApplicationContext());
    }

    public void dialogOnAddButtonPressed(String time, String date, String totalCho, String LDLCho, String HDLCho) {
        if (validateDate(date) && validateTime(time) && validateCholesterol(totalCho) && validateCholesterol(LDLCho) && validateCholesterol(HDLCho)) {
            CholesterolReading cReading = generateCholesterolReading(totalCho, LDLCho, HDLCho);
            dB.addCholesterolReading(cReading);
            activity.finishActivity();
        } else {
            activity.showErrorMessage();
        }
    }

    public void dialogOnAddButtonPressed(String time, String date, String totalCho, String LDLCho, String HDLCho, long oldId) {
        if (validateDate(date) && validateTime(time) && validateCholesterol(totalCho) && validateCholesterol(LDLCho) && validateCholesterol(HDLCho)) {
            CholesterolReading cReading = generateCholesterolReading(totalCho, LDLCho, HDLCho);
            dB.editCholesterolReading(oldId, cReading);
            activity.finishActivity();
        } else {
            activity.showErrorMessage();

        }
    }

    private CholesterolReading generateCholesterolReading(String totalCho, String LDLCho, String HDLCho) {
        Date finalDateTime = getReadingTime();
        double totalChoFinal = ReadingTools.safeParseDouble(totalCho);
        double LDLChoFinal = ReadingTools.safeParseDouble(LDLCho);
        double HDLChoFinal = ReadingTools.safeParseDouble(HDLCho);
        return new CholesterolReading(totalChoFinal, LDLChoFinal, HDLChoFinal, finalDateTime);
    }

    public String getUnitMeasurement() {
        return dB.getUser(1).getPreferred_unit();
    }

    public CholesterolReading getCholesterolReadingById(Long id) {
        return dB.getCholesterolReading(id);
    }

    // Validator
    private boolean validateCholesterol(String reading) {
        return validateText(reading);
    }
}
