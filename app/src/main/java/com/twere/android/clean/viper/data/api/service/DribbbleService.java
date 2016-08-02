package com.twere.android.clean.viper.data.api.service;

import com.twere.android.clean.viper.entity.Shot;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface DribbbleService {
  @GET("shots?access_token=a1e5d49824b3ed9584e902bf0b0bfdbe3cd7f4e60c6a908e5f5673141530956e")
  Observable<List<Shot>> shots();
}
