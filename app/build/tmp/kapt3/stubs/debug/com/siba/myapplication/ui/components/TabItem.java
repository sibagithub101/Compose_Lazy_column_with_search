package com.siba.myapplication.ui.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013B\"\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007\u00a2\u0006\u0002\u0010\bR\u001c\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem;", "", "title", "", "screen", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getScreen", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "Business", "Entertainment", "General", "Health", "Science", "Sports", "Technology", "Lcom/siba/myapplication/ui/components/TabItem$Business;", "Lcom/siba/myapplication/ui/components/TabItem$Entertainment;", "Lcom/siba/myapplication/ui/components/TabItem$General;", "Lcom/siba/myapplication/ui/components/TabItem$Health;", "Lcom/siba/myapplication/ui/components/TabItem$Science;", "Lcom/siba/myapplication/ui/components/TabItem$Sports;", "Lcom/siba/myapplication/ui/components/TabItem$Technology;", "app_debug"})
public abstract class TabItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function0<kotlin.Unit> screen = null;
    
    private TabItem(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> screen) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getScreen() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$Business;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class Business extends com.siba.myapplication.ui.components.TabItem {
        
        public Business(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$Entertainment;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class Entertainment extends com.siba.myapplication.ui.components.TabItem {
        
        public Entertainment(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$General;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class General extends com.siba.myapplication.ui.components.TabItem {
        
        public General(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$Health;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class Health extends com.siba.myapplication.ui.components.TabItem {
        
        public Health(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$Science;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class Science extends com.siba.myapplication.ui.components.TabItem {
        
        public Science(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$Technology;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class Technology extends com.siba.myapplication.ui.components.TabItem {
        
        public Technology(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/siba/myapplication/ui/components/TabItem$Sports;", "Lcom/siba/myapplication/ui/components/TabItem;", "newsViewModel", "Lcom/siba/myapplication/ui/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "(Lcom/siba/myapplication/ui/NewsViewModel;Landroidx/navigation/NavController;)V", "app_debug"})
    public static final class Sports extends com.siba.myapplication.ui.components.TabItem {
        
        public Sports(@org.jetbrains.annotations.NotNull
        com.siba.myapplication.ui.NewsViewModel newsViewModel, @org.jetbrains.annotations.NotNull
        androidx.navigation.NavController navController) {
            super(null, null);
        }
    }
}