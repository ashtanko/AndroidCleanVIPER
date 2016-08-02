package com.twere.android.clean.viper.presenter;

import com.twere.android.clean.viper.view.BaseMainView;
import com.twere.android.clean.viper.router.MainRouter;

public abstract class BaseMainPresenter<View extends BaseMainView>
    extends BasePresenter<View, MainRouter> {
}
