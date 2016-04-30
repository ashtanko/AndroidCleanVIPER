package com.twere.android.clean.viper.presentation.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.domain.shot.Shot;
import com.twere.android.clean.viper.presentation.common.BaseActivity;
import com.twere.android.clean.viper.presentation.common.BindLayout;
import com.twere.android.clean.viper.presentation.injection.component.ActivityComponent;
import com.twere.android.clean.viper.presentation.injection.component.DaggerActivityComponent;
import com.twere.android.clean.viper.presentation.injection.module.DataModule;
import com.twere.android.clean.viper.presentation.injection.module.DomainModule;
import com.twere.android.clean.viper.presentation.main.modules.common.BaseMainFragment;
import com.twere.android.clean.viper.presentation.main.modules.shot.ShotFragment;
import dagger.internal.Preconditions;

@BindLayout(id = R.layout.activity_main) public class MainActivity extends BaseActivity
    implements MainRouter {

  @Bind(R.id.toolbar) Toolbar toolbar;

  private ActivityComponent activityComponent;

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    if (getSupportFragmentManager().getBackStackEntryCount() == 0) addBackStack(new ShotFragment());
    return super.onCreateOptionsMenu(menu);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setSupportActionBar(toolbar);
    activityComponent = DaggerActivityComponent.builder()
        .dataModule(new DataModule())
        .domainModule(new DomainModule())
        .build();
  }

  private void addBackStack(BaseMainFragment fragment) {
    Preconditions.checkNotNull(fragment);
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.content, fragment);
    transaction.addToBackStack(fragment.getFragmentName());
    transaction.commit();
  }

  public void resolveToolbar(BaseMainFragment fragment) {
    toolbar.setTitle(fragment.getTitle());
    if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
      toolbar.setNavigationOnClickListener(view -> onBackPressed());
    } else {
      toolbar.setNavigationOnClickListener(null);
    }
  }

  public ActivityComponent getActivityComponent() {
    return activityComponent;
  }

  @Override public void showMessage(Shot shot) {

  }

  @Override public void openShot() {

  }
}
