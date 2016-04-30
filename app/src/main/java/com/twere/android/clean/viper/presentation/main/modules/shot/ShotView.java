package com.twere.android.clean.viper.presentation.main.modules.shot;

import com.twere.android.clean.viper.domain.shot.Shot;
import com.twere.android.clean.viper.presentation.main.modules.common.BaseMainView;
import java.util.List;

public interface ShotView extends BaseMainView {
  void setShots(List<Shot> shots);
}
