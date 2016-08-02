package com.twere.android.clean.viper.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.entity.Shot;
import com.twere.android.clean.viper.view.BindLayout;
import com.twere.android.clean.viper.assembly.component.ActivityComponent;
import com.twere.android.clean.viper.assembly.component.DaggerActivityComponent;
import com.twere.android.clean.viper.assembly.module.DataModule;
import com.twere.android.clean.viper.assembly.module.DomainModule;
import com.twere.android.clean.viper.ui.fragment.BaseMainFragment;
import com.twere.android.clean.viper.ui.fragment.ShotFragment;
import com.twere.android.clean.viper.router.MainRouter;
import dagger.internal.Preconditions;

@BindLayout(id = R.layout.activity_main) public class MainActivity extends BaseActivity
    implements MainRouter {

  @Bind(R.id.toolbar)public Toolbar toolbar;

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

  @Override public void showShot(Shot shot) {
    Intent intent = new Intent(MainActivity.this, ShotActivity.class);
    intent.putExtra(Shot.class.getCanonicalName(), shot);
    startActivity(intent);
  }

  @Override public void openShot() {

  }
}
