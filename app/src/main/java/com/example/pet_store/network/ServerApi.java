package com.example.pet_store.network;


import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.login.model.LoginResponseObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServerApi {

    @GET("user/login")
    Call<LoginResponseObject> login(
            @Query("username") String username,
            @Query("password") String password);

    @GET("pet/findByStatus")
    Call<List<PetListObject>> getPetList(
            @Query("status") String status);

    @GET("pet/{id}")
    Call<PetListObject> detailsPet(
            @Path("id") long id);

    @POST("pet")
    Call<PetListObject> postPet(
            @Field("name") String status);


}
