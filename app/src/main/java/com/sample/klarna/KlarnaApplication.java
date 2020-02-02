package com.sample.klarna;

import androidx.multidex.MultiDexApplication;

import com.sample.klarna.datainjection.DependencyInjector;

public class KlarnaApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        DependencyInjector.initialize(this);
    }
}
