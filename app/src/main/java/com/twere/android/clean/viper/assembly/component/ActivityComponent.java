package com.twere.android.clean.viper.assembly.component;

import com.twere.android.clean.viper.assembly.module.DataModule;
import com.twere.android.clean.viper.assembly.module.DomainModule;
import com.twere.android.clean.viper.ui.fragment.ShotFragment;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { DomainModule.class, DataModule.class })
public interface ActivityComponent {
  void inject(ShotFragment fragment);
}
