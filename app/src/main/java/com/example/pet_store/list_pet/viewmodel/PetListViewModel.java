package com.example.pet_store.list_pet.viewmodel;

import android.util.Log;

import com.example.pet_store.Repository.ResponseLogin;
import com.example.pet_store.Repository.ResponsePetList;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.login.model.LoginResponseObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class PetListViewModel extends ViewModel {
    private ResponsePetList responsePetList;
    private LiveData<ArrayList<PetListObject>> setList = new MutableLiveData<>();


    @Inject
    public PetListViewModel(ResponsePetList responsePetList) {
        this.responsePetList = responsePetList;
    }

    public void setPetList(String status) {
     setList =  responsePetList.setListObjectStatus(status);
    }

    public LiveData<ArrayList<PetListObject>> observeList() {
        return setList;
    }

}
