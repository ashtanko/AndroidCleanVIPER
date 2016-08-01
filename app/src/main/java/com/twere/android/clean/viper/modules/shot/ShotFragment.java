package com.twere.android.clean.viper.modules.shot;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.common.data.local.entity.Shot;
import com.twere.android.clean.viper.common.view.BasePresenter;
import com.twere.android.clean.viper.common.view.BindLayout;
import com.twere.android.clean.viper.modules.common.BaseMainFragment;
import java.util.List;
import javax.inject.Inject;

@BindLayout(id = R.layout.recycler_view) public class ShotFragment extends BaseMainFragment
    implements ShotView {

  @Inject ShotPresenter presenter;

  @Bind(R.id.chats_recycler_view) RecyclerView recyclerView;

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
    ShotAdapter adapter = new ShotAdapter(shots);
    adapter.setOnItemClickListener(view -> presenter.selectedShot((Shot) view.getTag()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void showNewMessagesNotification() {

  }
}
