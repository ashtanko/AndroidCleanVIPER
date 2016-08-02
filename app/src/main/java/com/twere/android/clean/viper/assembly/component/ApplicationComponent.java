package com.twere.android.clean.viper.assembly.component;

import android.content.Context;
import com.twere.android.clean.viper.assembly.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

  Context context();
}
