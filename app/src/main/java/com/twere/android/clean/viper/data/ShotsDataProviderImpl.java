package com.twere.android.clean.viper.data;

import com.twere.android.clean.viper.BuildConfig;
import com.twere.android.clean.viper.data.api.DribbbleService;
import com.twere.android.clean.viper.domain.shot.Shot;
import com.twere.android.clean.viper.domain.shot.ShotDataProvider;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShotsDataProviderImpl implements ShotDataProvider {

  private DribbbleService service; //need injected

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
