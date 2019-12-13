// Generated code from Butter Knife. Do not modify!
package com.diabites.android.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.diabites.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AssistantFragment_ViewBinding implements Unbinder {
  private AssistantFragment target;

  private View view2131296436;

  private View view2131296437;

  @UiThread
  public AssistantFragment_ViewBinding(final AssistantFragment target, View source) {
    this.target = target;

    View view;
    target.tipsRecycler = Utils.findRequiredViewAsType(source, R.id.fragment_tips_recyclerview, "field 'tipsRecycler'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fragment_assistant_archived, "field 'archivedButton' and method 'archivedButtonClicked'");
    target.archivedButton = Utils.castView(view, R.id.fragment_assistant_archived, "field 'archivedButton'", LinearLayout.class);
    view2131296436 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.archivedButtonClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_assistant_archived_dismiss, "field 'archivedDismissButton' and method 'archivedDismissButtonClick'");
    target.archivedDismissButton = Utils.castView(view, R.id.fragment_assistant_archived_dismiss, "field 'archivedDismissButton'", LinearLayout.class);
    view2131296437 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.archivedDismissButtonClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AssistantFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tipsRecycler = null;
    target.archivedButton = null;
    target.archivedDismissButton = null;

    view2131296436.setOnClickListener(null);
    view2131296436 = null;
    view2131296437.setOnClickListener(null);
    view2131296437 = null;
  }
}
