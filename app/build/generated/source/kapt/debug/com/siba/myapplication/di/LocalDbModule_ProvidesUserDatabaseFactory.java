package com.siba.myapplication.di;

import android.content.Context;
import com.siba.myapplication.roomdb.NewsDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class LocalDbModule_ProvidesUserDatabaseFactory implements Factory<NewsDatabase> {
  private final Provider<Context> contextProvider;

  public LocalDbModule_ProvidesUserDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NewsDatabase get() {
    return providesUserDatabase(contextProvider.get());
  }

  public static LocalDbModule_ProvidesUserDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new LocalDbModule_ProvidesUserDatabaseFactory(contextProvider);
  }

  public static NewsDatabase providesUserDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(LocalDbModule.INSTANCE.providesUserDatabase(context));
  }
}
