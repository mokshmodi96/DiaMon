/*
 * Copyright (C) 2016 Glucosio Foundation
 *
 * This file is part of Glucosio.
 *
 * Glucosio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * Glucosio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Glucosio.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */

package com.diabites.android;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import com.diabites.R;
import com.diabites.android.activity.A1cCalculatorActivity;
import com.diabites.android.activity.HelloActivity;

import com.diabites.android.db.DatabaseHandler;
import com.diabites.android.db.User;
import com.diabites.android.presenter.A1CCalculatorPresenter;
import com.diabites.android.presenter.HelloPresenter;
import com.diabites.android.tools.Preferences;



import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class GlucosioApplication extends Application {

    private static GlucosioApplication sInstance;



    @Nullable
    private Preferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initFont();
        initLanguage();
    }

    @VisibleForTesting
    protected void initFont() {
        //TODO: convert of using new introduced class Preferences
        // Get Dyslexia preference and adjust font
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDyslexicModeOn = sharedPref.getBoolean("pref_font_dyslexia", false);

        if (isDyslexicModeOn) {
            setFont("fonts/opendyslexic.otf");
        } else {
            setFont("fonts/lato.ttf");
        }
    }

    @VisibleForTesting
    protected void initLanguage() {
        User user = getDBHandler().getUser(1);
        if (user != null) {
            checkBadLocale(user);

            String languageTag = user.getPreferred_language();

        }
    }

    private void checkBadLocale(User user) {
        Preferences preferences = getPreferences();
        boolean cleanLocaleDone = preferences.isLocaleCleaned();

        if (!cleanLocaleDone) {
            User updatedUser = new User(user);
            updatedUser.setPreferred_language(null);
            //TODO: is it long operation? should we move it to separate thread?
            getDBHandler().updateUser(updatedUser);
            preferences.saveLocaleCleaned();
        }
    }

    private void setFont(String font) {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(font)
                .setFontAttrId(R.attr.fontPath)
                .build());
    }



    @NonNull
    public DatabaseHandler getDBHandler() {
        return new DatabaseHandler(getApplicationContext());
    }

    @NonNull
    public A1CCalculatorPresenter createA1cCalculatorPresenter(@NonNull final A1cCalculatorActivity activity) {
        return new A1CCalculatorPresenter(activity, getDBHandler());
    }



    @NonNull
    public Preferences getPreferences() {
        if (preferences == null) {
            preferences = new Preferences(this);
        }

        return preferences;
    }

    public static GlucosioApplication getInstance() {
        if (sInstance == null) {
            sInstance = new GlucosioApplication();
        }
        return sInstance;
    }

    @NonNull
    public HelloPresenter createHelloPresenter(@NonNull final HelloActivity activity) {
        return new HelloPresenter(activity, getDBHandler());
    }
}
