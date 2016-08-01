package com.twere.android.clean.viper.modules.shot;

import com.twere.android.clean.viper.common.data.local.entity.Shot;
import com.twere.android.clean.viper.modules.common.BaseMainView;
import java.util.List;

interface ShotView extends BaseMainView {
  void setShots(List<Shot> shots);
}
