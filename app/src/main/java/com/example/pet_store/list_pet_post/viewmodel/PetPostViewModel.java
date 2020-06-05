package com.example.pet_store.list_pet_post.viewmodel;


import android.view.View;

import com.example.pet_store.Repository.ResponseAddNewPet;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.login.model.LoginResponseObject;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PetPostViewModel extends ViewModel {

    public MutableLiveData<String> Name = new MutableLiveData<>();
    public MutableLiveData<String> PhotoUrl = new MutableLiveData<>();

    private ResponseAddNewPet responseAddNewPet;
    private LiveData<PetListObject> postPet = new MutableLiveData<>();
    @Inject
    public PetPostViewModel(ResponseAddNewPet responseAddNewPet){
        this.responseAddNewPet = responseAddNewPet ;
    }
    public LiveData<PetListObject> observePostList() {
        return postPet;
    }

    public void onClick(View view){
      postPetObject(Name.getValue(),PhotoUrl.getValue());
    }
  public void postPetObject(String Name, String PhotoUrl) {
  }

}
