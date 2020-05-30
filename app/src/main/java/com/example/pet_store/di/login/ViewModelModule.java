package com.example.pet_store.di.login;

import com.example.pet_store.di.ViewModelKey;
import com.example.pet_store.login.viewmodel.LoginViewModel;
import com.example.pet_store.viewmodels.ViewModelProviderFactory;

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
    abstract ViewModelProvider.Factory bindViewModelFactory (ViewModelProviderFactory providerFactory);


}
