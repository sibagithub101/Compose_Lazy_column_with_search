package com.siba.myapplication.ui;

import com.siba.myapplication.data.local.repository.LocalNewsRepository;
import com.siba.myapplication.data.remote.repository.NewsRepository;
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
public final class NewsViewModel_Factory implements Factory<NewsViewModel> {
  private final Provider<NewsRepository> repositoryProvider;

  private final Provider<LocalNewsRepository> localRepositoryProvider;

  public NewsViewModel_Factory(Provider<NewsRepository> repositoryProvider,
      Provider<LocalNewsRepository> localRepositoryProvider) {
    this.repositoryProvider = repositoryProvider;
    this.localRepositoryProvider = localRepositoryProvider;
  }

  @Override
  public NewsViewModel get() {
    return newInstance(repositoryProvider.get(), localRepositoryProvider.get());
  }

  public static NewsViewModel_Factory create(Provider<NewsRepository> repositoryProvider,
      Provider<LocalNewsRepository> localRepositoryProvider) {
    return new NewsViewModel_Factory(repositoryProvider, localRepositoryProvider);
  }

  public static NewsViewModel newInstance(NewsRepository repository,
      LocalNewsRepository localRepository) {
    return new NewsViewModel(repository, localRepository);
  }
}
