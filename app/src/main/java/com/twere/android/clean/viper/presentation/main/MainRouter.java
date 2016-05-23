package com.twere.android.clean.viper.presentation.main;

import com.twere.android.clean.viper.domain.shot.Shot;

public interface MainRouter {
  void showShot(Shot shot);

  void openShot();
}
