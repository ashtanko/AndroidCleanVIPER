package com.twere.android.clean.viper.presentation.main.modules.shot;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.twere.android.clean.viper.R;
import com.twere.android.clean.viper.domain.shot.Shot;
import java.util.List;

public class ShotAdapter extends RecyclerView.Adapter<ShotAdapter.ShotViewHolder> {

  private final List<Shot> shots;

  public ShotAdapter(List<Shot> shots) {
    this.shots = shots;
  }

  @Override public ShotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View convertView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.shot_view, parent, false);
    return new ShotViewHolder(convertView);
  }

  @Override public void onBindViewHolder(ShotViewHolder holder, int position) {
    holder.bind(shots.get(position));
  }

  @Override public int getItemCount() {
    return shots.size();
  }

  public class ShotViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.shot_id) TextView shotId;

    public ShotViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void bind(Shot shot) {
      shotId.setText(shot.getTitle());
    }
  }
}
