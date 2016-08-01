package com.twere.android.clean.viper.modules.shot;

import com.twere.android.clean.viper.common.Interactor;
import com.twere.android.clean.viper.assembly.module.DomainModule;
import com.twere.android.clean.viper.common.data.local.entity.Shot;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import rx.Observable;
import rx.Scheduler;

class GetShotsInteractor extends Interactor<List<Shot>, Void> {

  private final ShotDataProvider provider;

  @Inject public GetShotsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
      @Named(DomainModule.UI) Scheduler uiScheduler, ShotDataProvider provider) {
    super(jobScheduler, uiScheduler);
    this.provider = provider;
  }

  @Override protected Observable<List<Shot>> buildObservable(Void parameter) {
    return provider.getAllShots();
  }
}
