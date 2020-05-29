package com.example.pet_store.di.modul;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ContextModule {
    @Binds
    abstract Context provideContext(Application application);

}
