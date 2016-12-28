package com.app.weather.activity;

import com.app.weather.presenter.SelectCityPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SelectCityActivity_MembersInjector
    implements MembersInjector<SelectCityActivity> {
  private final Provider<SelectCityPresenter> selectCityPresenterProvider;

  public SelectCityActivity_MembersInjector(
      Provider<SelectCityPresenter> selectCityPresenterProvider) {
    assert selectCityPresenterProvider != null;
    this.selectCityPresenterProvider = selectCityPresenterProvider;
  }

  public static MembersInjector<SelectCityActivity> create(
      Provider<SelectCityPresenter> selectCityPresenterProvider) {
    return new SelectCityActivity_MembersInjector(selectCityPresenterProvider);
  }

  @Override
  public void injectMembers(SelectCityActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.selectCityPresenter = selectCityPresenterProvider.get();
  }

  public static void injectSelectCityPresenter(
      SelectCityActivity instance, Provider<SelectCityPresenter> selectCityPresenterProvider) {
    instance.selectCityPresenter = selectCityPresenterProvider.get();
  }
}
