package io.shtanko.viper.presentation

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.github.salomonbrys.kodein.lazy
import io.shtanko.viper.logV


class AppDelegate : Application(), KodeinAware {

  override val kodein by Kodein.lazy {
    import(autoAndroidModule(this@AppDelegate))
  }

  override fun onCreate() {
    super.onCreate()

    logV(kodein.container)

  }
}