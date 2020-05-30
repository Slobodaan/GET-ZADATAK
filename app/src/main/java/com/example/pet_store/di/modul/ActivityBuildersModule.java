package com.example.pet_store.di.modul;

import com.example.pet_store.di.login.LoginModule;
import com.example.pet_store.di.login.ViewModelModule;
import com.example.pet_store.login.view.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    ViewModelModule.class,
                    LoginModule.class
            }
    )
    abstract LoginActivity contributeLoginActivity();
}
