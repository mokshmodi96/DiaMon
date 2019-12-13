
package com.diabites.android.presenter;


import com.diabites.android.fragment.AssistantFragment;

public class AssistantPresenter {
    private AssistantFragment fragment;

    public AssistantPresenter(AssistantFragment assistantFragment) {
        this.fragment = assistantFragment;
    }

    public void userAskedAddReading() {
        fragment.addReading();
    }

    public void userAskedExport() {
        fragment.startExportActivity();
    }

    public void userAskedA1CCalculator() {
        fragment.startA1CCalculatorActivity();
    }

    public void userSupportAsked() {
        fragment.openSupportDialog();
    }
}
