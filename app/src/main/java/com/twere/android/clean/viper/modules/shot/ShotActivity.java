package com.twere.android.clean.viper.modules.shot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.common.data.local.entity.Shot;
import com.twere.android.clean.viper.common.view.BaseActivity;
import com.twere.android.clean.viper.common.view.BindLayout;

@BindLayout(id = R.layout.activity_shot) public class ShotActivity extends BaseActivity {

  @Bind(R.id.toolbar) Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    toolbar.setNavigationOnClickListener(view -> finish());
    Shot shot = getIntent().getParcelableExtra(Shot.class.getCanonicalName());
    setTitle(shot.getTitle());
  }
}
