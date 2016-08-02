package com.twere.android.clean.viper.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.entity.Shot;
import com.twere.android.clean.viper.presenter.BasePresenter;
import com.twere.android.clean.viper.view.BindLayout;
import com.twere.android.clean.viper.view.ShotView;
import com.twere.android.clean.viper.presenter.ShotPresenter;
import com.twere.android.clean.viper.ui.adapter.ShotAdapter;
import java.util.List;
import javax.inject.Inject;

@BindLayout(id = R.layout.recycler_view) public class ShotFragment extends BaseMainFragment
    implements ShotView {

  @Inject public ShotPresenter presenter;

  @Bind(R.id.chats_recycler_view) public RecyclerView recyclerView;

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
