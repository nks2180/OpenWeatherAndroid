package com.app.weather.presenter;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SelectCityPresenter_Factory implements Factory<SelectCityPresenter> {
  private final MembersInjector<SelectCityPresenter> selectCityPresenterMembersInjector;

  private final Provider<Context> baseContextProvider;

  public SelectCityPresenter_Factory(
      MembersInjector<SelectCityPresenter> selectCityPresenterMembersInjector,
      Provider<Context> baseContextProvider) {
    assert selectCityPresenterMembersInjector != null;
    this.selectCityPresenterMembersInjector = selectCityPresenterMembersInjector;
    assert baseContextProvider != null;
    this.baseContextProvider = baseContextProvider;
  }

  @Override
  public SelectCityPresenter get() {
    return MembersInjectors.injectMembers(
        selectCityPresenterMembersInjector, new SelectCityPresenter(baseContextProvider.get()));
  }

  public static Factory<SelectCityPresenter> create(
      MembersInjector<SelectCityPresenter> selectCityPresenterMembersInjector,
      Provider<Context> baseContextProvider) {
    return new SelectCityPresenter_Factory(selectCityPresenterMembersInjector, baseContextProvider);
  }
}
