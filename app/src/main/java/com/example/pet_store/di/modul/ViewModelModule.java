package com.example.pet_store.di.modul;

import com.example.pet_store.di.ViewModelKey;
import com.example.pet_store.list_pet.viewmodel.PetListViewModel;
import com.example.pet_store.list_pet_details.viewmodel.PetDetailsViewModel;
import com.example.pet_store.list_pet_post.viewmodel.PetPostViewModel;
import com.example.pet_store.login.viewmodel.LoginViewModel;
import com.example.pet_store.di.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PetListViewModel.class)
    public abstract ViewModel bindPetListViewModel(PetListViewModel petListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PetPostViewModel.class)
    public abstract ViewModel bindAddPetViewModel(PetPostViewModel addPetViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PetDetailsViewModel.class)
    public abstract ViewModel bindPetDetails(PetDetailsViewModel petDetailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory (ViewModelProviderFactory providerFactory);


}
