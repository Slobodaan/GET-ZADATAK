package com.example.pet_store.di.modul;


import com.example.pet_store.list_pet.view.PetListActivity;
import com.example.pet_store.list_pet_details.view.PetDetailsActivity;
import com.example.pet_store.list_pet_post.view.AddNewPet;
import com.example.pet_store.login.view.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {


    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();

//    @PerActivity
//    @ContributesAndroidInjector(modules = {LaunchScreenBuilderModule.class})
    @ContributesAndroidInjector
    abstract PetListActivity contributePetListActivity();

    @ContributesAndroidInjector
    abstract PetDetailsActivity contributePetDetails();

    @ContributesAndroidInjector
    abstract AddNewPet contributeAddPetNew();
}
