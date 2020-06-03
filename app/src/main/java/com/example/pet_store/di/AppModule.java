package com.example.pet_store.di;

import com.example.pet_store.Repository.ResponseAddNewPet;
import com.example.pet_store.Repository.ResponseLogin;
import com.example.pet_store.Repository.ResponsePetDetails;
import com.example.pet_store.Repository.ResponsePetList;
import com.example.pet_store.di.modul.ViewModelModule;
import com.example.pet_store.network.ServerApi;

import com.example.pet_store.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Module(includes = {ViewModelModule.class})
public class AppModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static ServerApi provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ServerApi.class);
    }

    @Singleton
    @Provides
    static ResponseLogin provideRetrofitResponse(ServerApi serverApi) {
        return new ResponseLogin(serverApi);
    }

    @Singleton
    @Provides
    static ResponsePetList provideResponse(ServerApi serverApi) {
        return new ResponsePetList(serverApi);
    }

    @Singleton
    @Provides
    static ResponseAddNewPet provideResponseAddPet(ServerApi serverApi) {
        return new ResponseAddNewPet(serverApi);
    }

    @Singleton
    @Provides
    static ResponsePetDetails provideResponseDetails(ServerApi serverApi) {
        return new ResponsePetDetails(serverApi);
    }

}
