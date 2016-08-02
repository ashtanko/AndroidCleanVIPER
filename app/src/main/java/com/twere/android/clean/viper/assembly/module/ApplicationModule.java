package com.twere.android.clean.viper.assembly.module;

import android.content.Context;
import com.twere.android.clean.viper.AndroidApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public final class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideAndroidContext() {
    return application;
  }
}
