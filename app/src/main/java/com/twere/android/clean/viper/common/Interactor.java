package com.twere.android.clean.viper.common;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

public abstract class Interactor<ResultType, ParameterType> {

  private final CompositeSubscription subscription = new CompositeSubscription();
  private final Scheduler jobScheduler;
  private final Scheduler uiScheduler;

  public Interactor(Scheduler jobScheduler, Scheduler uiScheduler) {
    this.jobScheduler = jobScheduler;
    this.uiScheduler = uiScheduler;
  }

  protected abstract Observable<ResultType> buildObservable(ParameterType parameter);

  private void execute(ParameterType parameter, Subscriber<ResultType> subscriber) {
    subscription.add(buildObservable(parameter).subscribeOn(jobScheduler)
        .observeOn(uiScheduler)
        .subscribe(subscriber));
  }

  public void execute(Subscriber<ResultType> subscriber) {
    execute(null, subscriber);
  }

  public void unsubscribe() {
    subscription.clear();
  }
}
