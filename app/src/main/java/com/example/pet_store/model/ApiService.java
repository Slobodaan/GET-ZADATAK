package com.example.pet_store.model;

import com.example.pet_store.List.PetList;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("pet/findByStatus")
    Single<List<PetList>> getListPet();

}

