package com.twere.android.clean.viper.domain.shot;

import java.util.List;
import rx.Observable;

public interface ShotDataProvider {
  Observable<List<Shot>> getAllShots();
}
