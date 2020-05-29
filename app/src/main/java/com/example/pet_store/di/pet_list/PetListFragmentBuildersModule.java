package com.example.pet_store.di.pet_list;

import com.example.pet_store.login.PetListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PetListFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract PetListFragment provideListFragment();
}
