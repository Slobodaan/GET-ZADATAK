package com.example.pet_store.network.login;

import com.example.pet_store.models.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoginApi {

@GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
);
}
