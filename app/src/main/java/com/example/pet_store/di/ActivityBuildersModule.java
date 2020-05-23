package com.example.pet_store.di;

import com.example.pet_store.di.login.LoginViewModelsModule;
import com.example.pet_store.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    LoginViewModelsModule.class
            }
    )
    abstract LoginActivity contributeLoginActivity();
}
