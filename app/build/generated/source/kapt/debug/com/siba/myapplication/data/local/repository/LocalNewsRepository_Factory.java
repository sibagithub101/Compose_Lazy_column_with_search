package com.siba.myapplication.data.local.repository;

import com.siba.myapplication.data.local.dao.NewsDao;
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
public final class LocalNewsRepository_Factory implements Factory<LocalNewsRepository> {
  private final Provider<NewsDao> newsDaoProvider;

  public LocalNewsRepository_Factory(Provider<NewsDao> newsDaoProvider) {
    this.newsDaoProvider = newsDaoProvider;
  }

  @Override
  public LocalNewsRepository get() {
    return newInstance(newsDaoProvider.get());
  }

  public static LocalNewsRepository_Factory create(Provider<NewsDao> newsDaoProvider) {
    return new LocalNewsRepository_Factory(newsDaoProvider);
  }

  public static LocalNewsRepository newInstance(NewsDao newsDao) {
    return new LocalNewsRepository(newsDao);
  }
}
