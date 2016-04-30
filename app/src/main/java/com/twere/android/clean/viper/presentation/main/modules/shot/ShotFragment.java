package com.twere.android.clean.viper.presentation.main.modules.shot;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.domain.shot.Shot;
import com.twere.android.clean.viper.presentation.common.BasePresenter;
import com.twere.android.clean.viper.presentation.common.BindLayout;
import com.twere.android.clean.viper.presentation.main.modules.common.BaseMainFragment;
import java.util.List;
import javax.inject.Inject;

@BindLayout(id = R.layout.recycler_view) public class ShotFragment extends BaseMainFragment
    implements ShotView {

  @Inject ShotPresenter presenter;

  @Bind(R.id.chats_recycler_view) RecyclerView recyclerView;

  private ShotAdapter adapter;

  @Override public String getTitle() {
    return getString(R.string.shots);
  }

  @NonNull @Override protected BasePresenter getPresenter() {
    return presenter;
  }

  @Override protected void inject() {
    getActivityComponent().inject(this);
  }

  @Override public void setShots(List<Shot> shots) {
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    adapter = new ShotAdapter(shots);
    recyclerView.setAdapter(adapter);
  }

  @Override public void showNewMessagesNotification() {

  }
}
