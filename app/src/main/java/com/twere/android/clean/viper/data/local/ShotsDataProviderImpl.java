package com.twere.android.clean.viper.data.local;

import com.twere.android.clean.viper.BuildConfig;
import com.twere.android.clean.viper.data.api.service.DribbbleService;
import com.twere.android.clean.viper.entity.Shot;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShotsDataProviderImpl implements ShotDataProvider {

  private DribbbleService service;

  public ShotsDataProviderImpl() {
    service = new Retrofit.Builder().client(new OkHttpClient())
        .baseUrl(BuildConfig.ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
        .create(DribbbleService.class);
  }

  @Override public Observable<List<Shot>> getAllShots() {
    return shotListObservable().observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());
  }

  private Observable<List<Shot>> shotListObservable() {
    return service.shots().asObservable();
  }
}
