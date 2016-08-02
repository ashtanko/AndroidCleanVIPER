package com.twere.android.clean.viper.ui.fragment;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.twere.android.clean.viper.assembly.component.ActivityComponent;
import com.twere.android.clean.viper.ui.activity.MainActivity;
import com.twere.android.clean.viper.view.BaseMainView;

public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {

  public abstract String getTitle();

  @Override public void showError(@StringRes int message) {

  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setRetainInstance(true);
    MainActivity mainActivity = (MainActivity) getActivity();
    getPresenter().setRouter(mainActivity);
    mainActivity.resolveToolbar(this);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    getPresenter().setRouter(null);
  }

  protected ActivityComponent getActivityComponent() {
    return ((MainActivity) getActivity()).getActivityComponent();
  }
}
