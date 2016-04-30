package com.twere.android.clean.viper.domain.shot;

import com.twere.android.clean.viper.domain.common.Interactor;
import com.twere.android.clean.viper.presentation.injection.module.DomainModule;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import rx.Observable;
import rx.Scheduler;

public class GetShotsInteractor extends Interactor<List<Shot>, Void> {

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
