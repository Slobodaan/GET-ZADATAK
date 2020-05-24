package com.example.pet_store.di.login;

import com.example.pet_store.network.login.LoginApi;
import com.google.gson.internal.$Gson$Preconditions;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class LoginModule {

    @Provides
    static LoginApi provideLoginApi(Retrofit retrofit){
        return retrofit.create(LoginApi.class);
    }

}
