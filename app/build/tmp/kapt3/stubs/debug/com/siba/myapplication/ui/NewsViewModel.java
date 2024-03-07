package com.siba.myapplication.ui;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\tJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R6\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t0\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t0\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00180\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/siba/myapplication/ui/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/siba/myapplication/data/remote/repository/NewsRepository;", "localRepository", "Lcom/siba/myapplication/data/local/repository/LocalNewsRepository;", "(Lcom/siba/myapplication/data/remote/repository/NewsRepository;Lcom/siba/myapplication/data/local/repository/LocalNewsRepository;)V", "<set-?>", "Landroidx/compose/runtime/MutableState;", "", "Lcom/siba/myapplication/data/remote/model/ArticlesItem;", "newsArrayList", "getNewsArrayList", "()Landroidx/compose/runtime/MutableState;", "newsItem", "getNewsItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/siba/myapplication/ui/NewsResponseState;", "newsResponseState", "getNewsResponseState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/siba/myapplication/data/local/entity/ArticlesTable;", "newsTableList", "getNewsTableList", "", "selectedFilterItem", "getSelectedFilterItem", "filterNews", "", "query", "getAllData", "insertData", "articlesTable", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    private final com.siba.myapplication.data.remote.repository.NewsRepository repository = null;
    private final com.siba.myapplication.data.local.repository.LocalNewsRepository localRepository = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.siba.myapplication.ui.NewsResponseState> newsResponseState;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<com.siba.myapplication.data.remote.model.ArticlesItem> newsItem;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> selectedFilterItem;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.util.List<com.siba.myapplication.data.remote.model.ArticlesItem>> newsArrayList;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.util.List<com.siba.myapplication.data.local.entity.ArticlesTable>> newsTableList;
    
    @javax.inject.Inject
    public NewsViewModel(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.remote.repository.NewsRepository repository, @org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.local.repository.LocalNewsRepository localRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.siba.myapplication.ui.NewsResponseState> getNewsResponseState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<com.siba.myapplication.data.remote.model.ArticlesItem> getNewsItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getSelectedFilterItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.util.List<com.siba.myapplication.data.remote.model.ArticlesItem>> getNewsArrayList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.util.List<com.siba.myapplication.data.local.entity.ArticlesTable>> getNewsTableList() {
        return null;
    }
    
    public final void filterNews(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void insertData(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.local.entity.ArticlesTable articlesTable) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.siba.myapplication.data.local.entity.ArticlesTable> getAllData() {
        return null;
    }
}