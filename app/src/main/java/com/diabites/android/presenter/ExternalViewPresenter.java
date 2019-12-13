

package com.diabites.android.presenter;

import android.text.TextUtils;

import com.diabites.android.tools.network.NetworkConnectivity;


public class ExternalViewPresenter {

  private ExternalViewPresenter.View view;
  private NetworkConnectivity network;

  public ExternalViewPresenter(View view, NetworkConnectivity network) {
    this.view = view;
    this.network = network;
  }

  public void onViewCreated() {
    if (network.isConnected()) {
      String title = view.extractTitle();
      String url = view.extractUrl();
      parametersPrecondition(title, url);
      view.setupToolbarTitle(title);
      view.loadExternalUrl(url);
    } else {
      view.showNoConnectionWarning();
    }
  }

  private void parametersPrecondition(String title, String url) {
    if ((invalidParam(title)) || invalidParam(url)) {
      throw new IllegalArgumentException("Invalid arguments: need URL and TITLE");
    }
  }

  private boolean invalidParam(String url) {
    return TextUtils.isEmpty(url);
  }

  public interface View {
    void setupToolbarTitle(String link);

    String extractTitle();

    String extractUrl();

    void loadExternalUrl(String url);

    void showNoConnectionWarning();
  }
}
