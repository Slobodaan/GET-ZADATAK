package com.example.pet_store.Repository;

import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.network.ServerApi;
import javax.inject.Inject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ResponseAddNewPet {

    private ServerApi serverApi;
    @Inject
    public ResponseAddNewPet(ServerApi serverApi){
        this.serverApi = serverApi;
    }
}
