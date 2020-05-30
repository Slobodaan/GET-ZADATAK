package com.example.pet_store.di.login;

import com.example.pet_store.network.login.ServerApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class LoginModule {

    @Provides
    static ServerApi provideLoginApi(Retrofit retrofit){
        return retrofit.create(ServerApi.class);
    }

}
