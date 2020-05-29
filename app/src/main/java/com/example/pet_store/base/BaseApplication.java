package com.example.pet_store.base;



import android.app.Application;

import com.example.pet_store.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
     return   DaggerAppComponent.builder().application(this).build();  }
}
