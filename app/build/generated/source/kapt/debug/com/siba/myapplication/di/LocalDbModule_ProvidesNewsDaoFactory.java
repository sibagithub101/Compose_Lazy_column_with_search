package com.siba.myapplication.di;

import com.siba.myapplication.data.local.dao.NewsDao;
import com.siba.myapplication.roomdb.NewsDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class LocalDbModule_ProvidesNewsDaoFactory implements Factory<NewsDao> {
  private final Provider<NewsDatabase> databaseProvider;

  public LocalDbModule_ProvidesNewsDaoFactory(Provider<NewsDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public NewsDao get() {
    return providesNewsDao(databaseProvider.get());
  }

  public static LocalDbModule_ProvidesNewsDaoFactory create(
      Provider<NewsDatabase> databaseProvider) {
    return new LocalDbModule_ProvidesNewsDaoFactory(databaseProvider);
  }

  public static NewsDao providesNewsDao(NewsDatabase database) {
    return Preconditions.checkNotNullFromProvides(LocalDbModule.INSTANCE.providesNewsDao(database));
  }
}
