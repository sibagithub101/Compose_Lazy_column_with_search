package com.siba.myapplication.data.remote.repository;

import com.siba.myapplication.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NewsRepository_Factory implements Factory<NewsRepository> {
  private final Provider<ApiService> apiServiceProvider;

  public NewsRepository_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public NewsRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static NewsRepository_Factory create(Provider<ApiService> apiServiceProvider) {
    return new NewsRepository_Factory(apiServiceProvider);
  }

  public static NewsRepository newInstance(ApiService apiService) {
    return new NewsRepository(apiService);
  }
}
