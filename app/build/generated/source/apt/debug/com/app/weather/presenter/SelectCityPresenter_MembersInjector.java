package com.app.weather.presenter;

import com.app.weather.executor.ParsingExecutor;
import com.app.weather.retrofit.ApiController;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SelectCityPresenter_MembersInjector
    implements MembersInjector<SelectCityPresenter> {
  private final Provider<ApiController> apiControllerProvider;

  private final Provider<ParsingExecutor> parsingExecutorProvider;

  public SelectCityPresenter_MembersInjector(
      Provider<ApiController> apiControllerProvider,
      Provider<ParsingExecutor> parsingExecutorProvider) {
    assert apiControllerProvider != null;
    this.apiControllerProvider = apiControllerProvider;
    assert parsingExecutorProvider != null;
    this.parsingExecutorProvider = parsingExecutorProvider;
  }

  public static MembersInjector<SelectCityPresenter> create(
      Provider<ApiController> apiControllerProvider,
      Provider<ParsingExecutor> parsingExecutorProvider) {
    return new SelectCityPresenter_MembersInjector(apiControllerProvider, parsingExecutorProvider);
  }

  @Override
  public void injectMembers(SelectCityPresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.apiController = apiControllerProvider.get();
    instance.parsingExecutor = parsingExecutorProvider.get();
  }

  public static void injectApiController(
      SelectCityPresenter instance, Provider<ApiController> apiControllerProvider) {
    instance.apiController = apiControllerProvider.get();
  }

  public static void injectParsingExecutor(
      SelectCityPresenter instance, Provider<ParsingExecutor> parsingExecutorProvider) {
    instance.parsingExecutor = parsingExecutorProvider.get();
  }
}
