package com.twere.android.clean.viper.presentation.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import java.lang.annotation.Annotation;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseFragment extends Fragment {

  private static final AtomicInteger lastFragmentId = new AtomicInteger(0);
  private final int fragmentId;

  public BaseFragment() {
    fragmentId = lastFragmentId.incrementAndGet();
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    Class cls = getClass();
    if (!cls.isAnnotationPresent(BindLayout.class)) return null;
    Annotation annotation = cls.getAnnotation(BindLayout.class);
    BindLayout bindLayout = (BindLayout) annotation;
    View view = inflater.inflate(bindLayout.id(), null);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    inject();
    //noinspection unchecked
    getPresenter().setView(this);
  }

  @Override public void onStart() {
    super.onStart();
    getPresenter().onStart();
  }

  @Override public void onStop() {
    super.onStop();
    getPresenter().onStop();
  }

  @Override public void onDestroyView() {
    ButterKnife.unbind(this);
    super.onDestroyView();
  }

  public String getFragmentName() {
    return Long.toString(fragmentId);
  }

  protected abstract BasePresenter getPresenter();

  protected abstract void inject();
}
