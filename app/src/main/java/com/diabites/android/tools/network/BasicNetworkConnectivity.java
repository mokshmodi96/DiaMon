

package com.diabites.android.tools.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.lang.ref.WeakReference;

public class BasicNetworkConnectivity implements NetworkConnectivity {

  private WeakReference<Context> context;

  public BasicNetworkConnectivity(Context context) {
    this.context = new WeakReference<>(context);
  }

  public boolean isConnected() {
    ConnectivityManager cm = provideConnectivityService(context.get());
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }

  private static ConnectivityManager provideConnectivityService(Context context) {
    return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
  }
}
