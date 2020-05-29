package com.example.pet_store.di.modul;

import com.example.pet_store.login.PetListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract PetListFragment provideListFragment();
}
