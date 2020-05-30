package com.example.pet_store.login.model;

import com.example.pet_store.network.ServerApi;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ResponseLogin {


    private ServerApi serverApi;

    @Inject
    public ResponseLogin(ServerApi serverApi) {
        this.serverApi = serverApi;
    }

    public LiveData<LoginResponseObject> registerUser(String username, String password) {
       MutableLiveData<LoginResponseObject> liveData = new MutableLiveData<>();

        Call<LoginResponseObject> response = serverApi.login(username, password);
        response.enqueue(new Callback<LoginResponseObject>() {
            @Override
            public void onResponse(Call<LoginResponseObject> call, Response<LoginResponseObject> response) {
                LoginResponseObject object = response.body();
                liveData.setValue(object);
            }

            @Override
            public void onFailure(Call<LoginResponseObject> call, Throwable t) {
            }
        });
        return liveData;
    }

}
