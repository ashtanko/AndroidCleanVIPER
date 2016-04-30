package com.twere.android.clean.viper.presentation.injection.component;

import com.twere.android.clean.viper.presentation.injection.module.DataModule;
import com.twere.android.clean.viper.presentation.injection.module.DomainModule;
import com.twere.android.clean.viper.presentation.main.modules.shot.ShotFragment;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { DomainModule.class, DataModule.class })
public interface ActivityComponent {
  void inject(ShotFragment fragment);
}
