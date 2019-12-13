package com.diabites.android.presenter;

import android.util.Log;

import com.diabites.android.activity.MainActivity;
import com.diabites.android.db.DatabaseHandler;



public class MainPresenter {

    private DatabaseHandler dB;

    public MainPresenter(MainActivity mainActivity, DatabaseHandler databaseHandler) {
        dB = databaseHandler;
        Log.i("msg::", "initiated dB object");
        if (dB.getUser(1) == null) {
            // if user doesn't exists start hello activity
            mainActivity.startHelloActivity();
        } else {
            // If user already exists, update user's preferred language and recreate CliendashMainActivity
//            mainActivity.getLocaleHelper().updateLanguage(mainActivity,
//                                                          dB.getUser(1).getPreferred_language());
        }
    }

    public boolean isdbEmpty() {
        return dB.getGlucoseReadings().size() == 0;
    }
}
