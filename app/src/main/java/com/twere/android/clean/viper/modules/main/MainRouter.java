package com.twere.android.clean.viper.modules.main;

import com.twere.android.clean.viper.common.data.local.entity.Shot;

public interface MainRouter {
  void showShot(Shot shot);

  void openShot();
}
