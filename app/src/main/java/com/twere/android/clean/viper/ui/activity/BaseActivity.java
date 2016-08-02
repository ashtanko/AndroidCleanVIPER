package com.twere.android.clean.viper.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.twere.android.clean.viper.view.BindLayout;
import java.lang.annotation.Annotation;

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Class cls = getClass();
    if (!cls.isAnnotationPresent(BindLayout.class)) return;
    Annotation annotation = cls.getAnnotation(BindLayout.class);
    BindLayout bindLayout = (BindLayout) annotation;
    setContentView(bindLayout.id());
    ButterKnife.bind(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }
}
