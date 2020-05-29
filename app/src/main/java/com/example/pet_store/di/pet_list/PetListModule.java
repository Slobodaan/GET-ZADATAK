package com.example.pet_store.di.pet_list;

import com.example.pet_store.network.pet_list.PetRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class PetListModule {

    @Provides
    static PetRepository providePetRepository(Retrofit retrofit){
        return retrofit.create(PetRepository.class);
    }
}
