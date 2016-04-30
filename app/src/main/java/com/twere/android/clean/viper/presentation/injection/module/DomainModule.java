package com.twere.android.clean.viper.presentation.injection.module;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module public final class DomainModule {

  public static final String JOB = "JOB_SCHEDULER";
  public static final String UI = "UI_SCHEDULER";

  @Provides @Singleton @Named(JOB) public Scheduler provideJobScheduler() {
    return Schedulers.computation();
  }

  @Provides @Singleton @Named(UI) public Scheduler provideUIScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
