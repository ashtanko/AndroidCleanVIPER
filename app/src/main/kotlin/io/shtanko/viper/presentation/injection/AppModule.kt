package io.shtanko.viper.presentation.injection

import dagger.Module
import dagger.Provides
import io.shtanko.viper.presentation.AppDelegate
import javax.inject.Singleton

@Module class AppModule(val app: AppDelegate) {

  @Provides @Singleton fun provideApp(): AppDelegate {
    return app
  }
}