package com.example.pet_store.di.pet_list;

import com.example.pet_store.di.ViewModelKey;
import com.example.pet_store.login.PetListViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PetListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PetListViewModel.class)
    abstract ViewModel bindListViewModel(PetListViewModel listViewModel);


}
