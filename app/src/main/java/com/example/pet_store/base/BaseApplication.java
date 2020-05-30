package com.example.pet_store.base;




import android.app.Activity;
import android.app.Application;

import com.example.pet_store.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import dagger.android.support.DaggerApplication;

public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();



        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


}
