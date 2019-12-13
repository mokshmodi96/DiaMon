// Generated code from Butter Knife. Do not modify!
package com.diabites.android.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.diabites.R;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Override;

public class A1cCalculatorActivity_ViewBinding implements Unbinder {
  private A1cCalculatorActivity target;

  private View view2131296299;

  private TextWatcher view2131296299TextWatcher;

  @UiThread
  public A1cCalculatorActivity_ViewBinding(A1cCalculatorActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public A1cCalculatorActivity_ViewBinding(final A1cCalculatorActivity target, View source) {
    this.target = target;

    View view;
    target.glucoseUnit = Utils.findRequiredViewAsType(source, R.id.activity_converter_a1c_glucose_unit, "field 'glucoseUnit'", TextView.class);
    target.A1CTextView = Utils.findRequiredViewAsType(source, R.id.activity_converter_a1c_a1c, "field 'A1CTextView'", TextView.class);
    target.A1cUnitTextView = Utils.findRequiredViewAsType(source, R.id.activity_converter_a1c_a1c_unit, "field 'A1cUnitTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.activity_converter_a1c_glucose, "method 'editorAction' and method 'glucoseValueChanged'");
    view2131296299 = view;
    ((TextView) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        return target.editorAction(p0, p1, p2);
      }
    });
    view2131296299TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
        target.glucoseValueChanged(p0);
      }
    };
    ((TextView) view).addTextChangedListener(view2131296299TextWatcher);
  }

  @Override
  @CallSuper
  public void unbind() {
    A1cCalculatorActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.glucoseUnit = null;
    target.A1CTextView = null;
    target.A1cUnitTextView = null;

    ((TextView) view2131296299).setOnEditorActionListener(null);
    ((TextView) view2131296299).removeTextChangedListener(view2131296299TextWatcher);
    view2131296299TextWatcher = null;
    view2131296299 = null;
  }
}
