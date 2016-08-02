package com.twere.android.clean.viper.view;

import android.support.annotation.StringRes;

public interface BaseMainView {
  void showError(@StringRes int message);

  void showNewMessagesNotification();
}
