package com.twere.android.clean.viper.view;

import com.twere.android.clean.viper.entity.Shot;
import java.util.List;

public interface ShotView extends BaseMainView {
  void setShots(List<Shot> shots);
}
