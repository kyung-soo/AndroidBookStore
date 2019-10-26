package com.example.bookstore;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSteho();
    }

    private void initSteho() {
        Stetho.initializeWithDefaults(this);
    }
}
