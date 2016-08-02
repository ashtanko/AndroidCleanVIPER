package com.twere.android.clean.viper;

import android.app.Application;
import com.twere.android.clean.viper.assembly.component.ApplicationComponent;
import com.twere.android.clean.viper.assembly.component.DaggerApplicationComponent;
import com.twere.android.clean.viper.assembly.module.ApplicationModule;

public final class AndroidApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    initAssembly();
  }

  private void initAssembly() {
    this.mApplicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return mApplicationComponent;
  }
}
