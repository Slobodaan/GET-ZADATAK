package com.example.pet_store.Repository;

import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.network.ServerApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponsePetList {
    private ServerApi serverApi;
    private  MutableLiveData<ArrayList<PetListObject>> liveData ;

    @Inject
    public ResponsePetList(ServerApi serverApi){
        this.serverApi = serverApi ;
        liveData = new MutableLiveData<>();
    }

    public void  setListObjectStatus(String status) {
        Call<List<PetListObject>> responseList = serverApi.getPetList(status);
        responseList.enqueue(new Callback<List<PetListObject>>() {
            @Override
            public void onResponse(Call<List<PetListObject>> call, Response<List<PetListObject>> response) {
                List<PetListObject> object = response.body() ;
               liveData.postValue((ArrayList)object);
            }
            @Override
            public void onFailure(Call<List<PetListObject>> call, Throwable t) {
               System.out.println(t.getMessage());
            }
        });
   }
    public  MutableLiveData<ArrayList<PetListObject>> getLiveData() {
        return liveData;
    }

 }
