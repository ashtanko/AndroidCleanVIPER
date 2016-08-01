package com.twere.android.clean.viper.modules.shot;

import com.twere.android.clean.viper.common.data.local.entity.Shot;
import java.util.List;
import rx.Observable;

public interface ShotDataProvider {
  Observable<List<Shot>> getAllShots();
}
