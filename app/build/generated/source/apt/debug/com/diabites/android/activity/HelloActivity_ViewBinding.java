// Generated code from Butter Knife. Do not modify!
package com.diabites.android.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.diabites.R;
import com.diabites.android.tools.LabelledSpinner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HelloActivity_ViewBinding implements Unbinder {
  private HelloActivity target;

  private View view2131296311;

  private View view2131296475;

  @UiThread
  public HelloActivity_ViewBinding(HelloActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HelloActivity_ViewBinding(final HelloActivity target, View source) {
    this.target = target;

    View view;
    target.countrySpinner = Utils.findRequiredViewAsType(source, R.id.activity_hello_spinner_country, "field 'countrySpinner'", LabelledSpinner.class);
    target.languageSpinner = Utils.findRequiredViewAsType(source, R.id.activity_hello_spinner_language, "field 'languageSpinner'", LabelledSpinner.class);
    target.genderSpinner = Utils.findRequiredViewAsType(source, R.id.activity_hello_spinner_gender, "field 'genderSpinner'", LabelledSpinner.class);
    target.typeSpinner = Utils.findRequiredViewAsType(source, R.id.activity_hello_spinner_diabetes_type, "field 'typeSpinner'", LabelledSpinner.class);
    target.unitSpinner = Utils.findRequiredViewAsType(source, R.id.activity_hello_spinner_preferred_unit, "field 'unitSpinner'", LabelledSpinner.class);
    view = Utils.findRequiredView(source, R.id.activity_hello_button_start, "field 'startButton' and method 'onStartClicked'");
    target.startButton = Utils.castView(view, R.id.activity_hello_button_start, "field 'startButton'", Button.class);
    view2131296311 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onStartClicked();
      }
    });
    target.ageTextView = Utils.findRequiredViewAsType(source, R.id.activity_hello_age, "field 'ageTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.helloactivity_textview_terms, "method 'onTermsAndConditionClick'");
    view2131296475 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTermsAndConditionClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HelloActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.countrySpinner = null;
    target.languageSpinner = null;
    target.genderSpinner = null;
    target.typeSpinner = null;
    target.unitSpinner = null;
    target.startButton = null;
    target.ageTextView = null;

    view2131296311.setOnClickListener(null);
    view2131296311 = null;
    view2131296475.setOnClickListener(null);
    view2131296475 = null;
  }
}
