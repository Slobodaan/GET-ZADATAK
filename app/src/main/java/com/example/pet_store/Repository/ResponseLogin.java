package com.example.pet_store.Repository;

import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.login.model.LoginResponseObject;
import com.example.pet_store.network.ServerApi;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ResponseLogin {


    private ServerApi serverApi;
    private  MutableLiveData<LoginResponseObject>  liveData ;

    @Inject
    public ResponseLogin(ServerApi serverApi) {
        this.serverApi = serverApi;
        liveData = new MutableLiveData<>();
    }

    public void  registerUser(String username,String password)  {


        Call<LoginResponseObject> response = serverApi.login(username, password);

        response.enqueue(new Callback<LoginResponseObject>() {
            @Override
            public void onResponse(Call<LoginResponseObject> call, Response<LoginResponseObject> response) {
                LoginResponseObject object = response.body();
                liveData.postValue(object);
            }

            @Override
            public void onFailure(Call<LoginResponseObject> call, Throwable t) {
            }
        });

    }
    public  MutableLiveData<LoginResponseObject> getLiveData() {
        return liveData;
    }
}
