package com.example.pet_store.network.login;

import com.example.pet_store.List.PetList;
import com.example.pet_store.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginApi {

@GET("user/login")
Call<User> getUser(
        @Query("username") String username,
        @Query("password") String password
);


}
