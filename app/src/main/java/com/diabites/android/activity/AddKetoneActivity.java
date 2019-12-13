package com.diabites.android.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;


import com.diabites.R;
import com.diabites.android.db.KetoneReading;
import com.diabites.android.presenter.AddKetonePresenter;
import com.diabites.android.tools.FormatDateTime;

import java.util.Calendar;

public class AddKetoneActivity extends AddReadingActivity {

    private TextView readingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ketone);
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setElevation(2);
        }

        this.retrieveExtra();

        AddKetonePresenter presenter = new AddKetonePresenter(this);
        this.setPresenter(presenter);
        presenter.setReadingTimeNow();

        readingTextView = findViewById(R.id.ketone_add_value);

        this.createDateTimeViewAndListener();
        this.createFANViewAndListener();

        // If an id is passed, open the activity in edit mode
        FormatDateTime formatDateTime = new FormatDateTime(getApplicationContext());
        if (this.isEditing()) {
            setTitle(R.string.title_activity_add_ketone_edit);
            KetoneReading readingToEdit = presenter.getKetoneReadingById(this.getEditId());
            readingTextView.setText(numberFormat.format(readingToEdit.getReading()));
            Calendar cal = Calendar.getInstance();
            cal.setTime(readingToEdit.getCreated());
            this.getAddDateTextView().setText(formatDateTime.getDate(cal));
            this.getAddTimeTextView().setText(formatDateTime.getTime(cal));
            presenter.updateReadingSplitDateTime(readingToEdit.getCreated());
        } else {
            this.getAddDateTextView().setText(formatDateTime.getCurrentDate());
            this.getAddTimeTextView().setText(formatDateTime.getCurrentTime());
        }
    }

    @Override
    protected void dialogOnAddButtonPressed() {
        AddKetonePresenter presenter = (AddKetonePresenter) getPresenter();
        if (this.isEditing()) {
            presenter.dialogOnAddButtonPressed(this.getAddTimeTextView().getText().toString(),
                    this.getAddDateTextView().getText().toString(), readingTextView.getText().toString().trim(), this.getEditId());
        } else {
            presenter.dialogOnAddButtonPressed(this.getAddTimeTextView().getText().toString(),
                    this.getAddDateTextView().getText().toString(), readingTextView.getText().toString().trim());
        }
    }

    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(), getString(R.string.dialog_error2), Toast.LENGTH_SHORT).show();
    }
}
