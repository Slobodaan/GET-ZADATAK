package com.example.pet_store.di.modul;

import com.example.pet_store.di.login.LoginModule;
import com.example.pet_store.di.login.LoginViewModelsModule;
import com.example.pet_store.login.LoginActivity;
import com.example.pet_store.network.login.LoginApi;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    LoginViewModelsModule.class,
                    LoginModule.class
            }
    )
    abstract LoginActivity contributeLoginActivity();
}
