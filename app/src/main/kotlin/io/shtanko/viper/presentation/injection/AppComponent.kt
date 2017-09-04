package io.shtanko.viper.presentation.injection

import dagger.Component
import javax.inject.Singleton

@Singleton @Component(
    modules = arrayOf(AppModule::class
    ))
interface AppComponent {

}