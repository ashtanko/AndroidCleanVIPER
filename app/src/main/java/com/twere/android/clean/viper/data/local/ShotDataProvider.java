package com.twere.android.clean.viper.data.local;

import com.twere.android.clean.viper.entity.Shot;
import java.util.List;
import rx.Observable;

public interface ShotDataProvider {
  Observable<List<Shot>> getAllShots();
}
