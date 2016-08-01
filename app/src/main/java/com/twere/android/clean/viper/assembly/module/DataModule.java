package com.twere.android.clean.viper.assembly.module;

import com.twere.android.clean.viper.BuildConfig;
import com.twere.android.clean.viper.modules.shot.ShotsDataProviderImpl;
import com.twere.android.clean.viper.common.data.api.DribbbleService;
import com.twere.android.clean.viper.modules.shot.ShotDataProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module public final class DataModule {

  @Provides @Singleton String provideBaseURL() {
    return BuildConfig.ENDPOINT;
  }

  @Provides @Singleton Retrofit provideRetrofit(String baseURL, @Named("Api") OkHttpClient client,
      Converter.Factory converter) {
    return new Retrofit.Builder().client(client)
        .baseUrl(baseURL)
        .addConverterFactory(converter)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
  }

  @Provides @Singleton DribbbleService provideDribbbleService(Retrofit retrofit) {
    return retrofit.create(DribbbleService.class);
  }

  @Provides @Singleton @Named("API") OkHttpClient provideApiClient(OkHttpClient client) {
    return createApiClient(client).build();
  }

  @Provides @Singleton ShotDataProvider provideShotDataProvider() {
    return new ShotsDataProviderImpl();
  }

  static OkHttpClient.Builder createApiClient(OkHttpClient client) {
    return client.newBuilder();
  }
}