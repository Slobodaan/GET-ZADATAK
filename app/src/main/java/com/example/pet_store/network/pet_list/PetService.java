package com.example.pet_store.network.pet_list;


import com.example.pet_store.model.PetStore;

import java.util.List;
import java.util.Observable;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PetService {

    @GET("orgs/Google/repos")
    Single<List<PetStore>> getRepositories();
}
