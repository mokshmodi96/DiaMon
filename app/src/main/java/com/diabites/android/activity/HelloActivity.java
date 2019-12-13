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

package com.diabites.android.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.diabites.R;
import com.diabites.android.GlucosioApplication;
import com.diabites.android.presenter.HelloPresenter;
import com.diabites.android.tools.LabelledSpinner;
import com.diabites.android.tools.network.GlucosioExternalLinks;
import com.diabites.android.view.HelloView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HelloActivity extends AppCompatActivity implements HelloView {

    @BindView(R.id.activity_hello_spinner_country)
    LabelledSpinner countrySpinner;

    @BindView(R.id.activity_hello_spinner_language)
    LabelledSpinner languageSpinner;

    @BindView(R.id.activity_hello_spinner_gender)
    LabelledSpinner genderSpinner;

    @BindView(R.id.activity_hello_spinner_diabetes_type)
    LabelledSpinner typeSpinner;

    @BindView(R.id.activity_hello_spinner_preferred_unit)
    LabelledSpinner unitSpinner;

    @BindView(R.id.activity_hello_button_start)
    Button startButton;

    @BindView(R.id.activity_hello_age)
    TextView ageTextView;

    private HelloPresenter presenter;

    private List<String> localesWithTranslation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        ButterKnife.bind(this);

        // Prevent SoftKeyboard to pop up on start
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        GlucosioApplication application = (GlucosioApplication) getApplication();
        presenter = application.createHelloPresenter(this);
        presenter.loadDatabase();



        genderSpinner.setItemsArray(R.array.helloactivity_gender_list);
        unitSpinner.setItemsArray(R.array.helloactivity_preferred_glucose_unit);
        typeSpinner.setItemsArray(R.array.helloactivity_diabetes_type);

        initStartButton();

        //showAnalyticsExplanationDialog();

        Log.i("HelloActivity", "Setting screen name: hello");


    }




    private void setSelection(final String label, final LabelledSpinner labelledSpinner) {
        if (label != null) {
            int position = ((ArrayAdapter) labelledSpinner.getSpinner().getAdapter()).getPosition(label);
            labelledSpinner.setSelection(position);
        }
    }

    private void initStartButton() {
        final Drawable pinkArrow = ResourcesCompat.getDrawable(getResources(),
                R.drawable.ic_navigate_next_pink_24px, null);
        if (pinkArrow != null) {
            pinkArrow.setBounds(0, 0, 60, 60);
            startButton.setCompoundDrawables(null, null, pinkArrow, null);
        }
    }



    @OnClick(R.id.activity_hello_button_start)
    void onStartClicked() {
        presenter.onNextClicked(ageTextView.getText().toString(),
                genderSpinner.getSpinner().getSelectedItem().toString(),
                "English",
                "India",
                typeSpinner.getSpinner().getSelectedItemPosition() + 1,
                unitSpinner.getSpinner().getSelectedItem().toString());
    }

    @OnClick(R.id.helloactivity_textview_terms)
    void onTermsAndConditionClick() {
        ExternalLinkActivity.launch(
            this,
            getString(R.string.preferences_terms),
            GlucosioExternalLinks.TERMS);
    }

    public void displayErrorWrongAge() {
        //Why toast and not error in edit box or dialog
        Toast.makeText(getApplicationContext(), getString(R.string.helloactivity_age_invalid), Toast.LENGTH_SHORT).show();
    }

    public void startMainView() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showAnalyticsExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.analytics_usage)
                .setMessage(R.string.analytics_usage_overview)
                .setCancelable(false)
                .setNegativeButton(R.string.optout, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        sharedPref.edit().putBoolean("pref_analytics_opt_in", false).apply();
                    }
                })
                .setPositiveButton(R.string.allow, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        sharedPref.edit().putBoolean("pref_analytics_opt_in", true).apply();
                        GlucosioApplication application = (GlucosioApplication) getApplication();

                    }
                })
                .show();
    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
