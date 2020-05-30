package com.example.pet_store.network.login;



import com.example.pet_store.model.LoginResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerApi {

    @GET("user/login")
    Call<LoginResponseObject> login(
            @Query("username") String username,
            @Query("password") String password
    );
}
