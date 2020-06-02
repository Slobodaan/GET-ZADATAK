package com.example.pet_store.list_pet_post.viewmodel;


import com.example.pet_store.Repository.ResponseAddNewPet;
import com.example.pet_store.list_pet.model.PetListObject;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddPetViewModel extends ViewModel {
    private ResponseAddNewPet responseAddNewPet;
    private LiveData<PetListObject> postPet = new MutableLiveData<>();
    @Inject
    public AddPetViewModel(ResponseAddNewPet responseAddNewPet){
        this.responseAddNewPet = responseAddNewPet ;
    }
    public LiveData<PetListObject> observePostList() {
        return postPet;
    }
}
