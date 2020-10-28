package com.example.nihao.net;

import android.app.Application;

public class AppTion extends Application {
    private static AppTion app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static AppTion getApp() {
        return app;
    }
}
