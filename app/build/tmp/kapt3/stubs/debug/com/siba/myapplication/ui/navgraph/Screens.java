package com.siba.myapplication.ui.navgraph;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/siba/myapplication/ui/navgraph/Screens;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "HomeScreen", "NewSDetailsScreen", "OfflineNewsScreen", "Lcom/siba/myapplication/ui/navgraph/Screens$HomeScreen;", "Lcom/siba/myapplication/ui/navgraph/Screens$NewSDetailsScreen;", "Lcom/siba/myapplication/ui/navgraph/Screens$OfflineNewsScreen;", "app_debug"})
public abstract class Screens {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Screens(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/siba/myapplication/ui/navgraph/Screens$HomeScreen;", "Lcom/siba/myapplication/ui/navgraph/Screens;", "()V", "app_debug"})
    public static final class HomeScreen extends com.siba.myapplication.ui.navgraph.Screens {
        @org.jetbrains.annotations.NotNull
        public static final com.siba.myapplication.ui.navgraph.Screens.HomeScreen INSTANCE = null;
        
        private HomeScreen() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/siba/myapplication/ui/navgraph/Screens$NewSDetailsScreen;", "Lcom/siba/myapplication/ui/navgraph/Screens;", "()V", "app_debug"})
    public static final class NewSDetailsScreen extends com.siba.myapplication.ui.navgraph.Screens {
        @org.jetbrains.annotations.NotNull
        public static final com.siba.myapplication.ui.navgraph.Screens.NewSDetailsScreen INSTANCE = null;
        
        private NewSDetailsScreen() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/siba/myapplication/ui/navgraph/Screens$OfflineNewsScreen;", "Lcom/siba/myapplication/ui/navgraph/Screens;", "()V", "app_debug"})
    public static final class OfflineNewsScreen extends com.siba.myapplication.ui.navgraph.Screens {
        @org.jetbrains.annotations.NotNull
        public static final com.siba.myapplication.ui.navgraph.Screens.OfflineNewsScreen INSTANCE = null;
        
        private OfflineNewsScreen() {
            super(null);
        }
    }
}