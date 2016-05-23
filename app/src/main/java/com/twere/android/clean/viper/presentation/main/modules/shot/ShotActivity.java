package com.twere.android.clean.viper.presentation.main.modules.shot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.domain.shot.Shot;
import com.twere.android.clean.viper.presentation.common.BaseActivity;
import com.twere.android.clean.viper.presentation.common.BindLayout;

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
