package com.twere.android.clean.viper.assembly.module;

import android.app.Application;
import com.twere.android.clean.viper.DribbbleApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public final class ApplicationModule {
  private final DribbbleApplication application;

  public ApplicationModule(DribbbleApplication application) {
    this.application = application;
  }

  @Provides @Singleton Application provideDribbbleApplication() {
    return application;
  }
}
