package com.twere.android.clean.viper.modules.shot;

import com.twere.android.clean.viper.common.data.local.entity.Shot;
import com.twere.android.clean.viper.modules.common.BaseMainPresenter;
import java.util.List;
import javax.inject.Inject;
import rx.Subscriber;

public class ShotPresenter extends BaseMainPresenter<ShotView> {

  private final GetShotsInteractor getShotsInteractor;

  @Inject public ShotPresenter(GetShotsInteractor getShotsInteractor) {
    this.getShotsInteractor = getShotsInteractor;
  }

  @Override public void onStart() {
    getShotsInteractor.execute(new Subscriber<List<Shot>>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(List<Shot> shots) {
        getView().setShots(shots);
      }
    });
  }

  @Override public void onStop() {
    getShotsInteractor.unsubscribe();
  }

  void selectedShot(Shot shot) {
    getRouter().showShot(shot);
  }
}