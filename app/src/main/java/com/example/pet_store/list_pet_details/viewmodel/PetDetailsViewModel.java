package com.example.pet_store.list_pet_details.viewmodel;

import com.example.pet_store.Repository.ResponsePetDetails;
import com.example.pet_store.list_pet.model.PetListObject;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PetDetailsViewModel extends ViewModel {

    private ResponsePetDetails responsePetDetails;
    private MutableLiveData<PetListObject> setDetails;

    @Inject
    public PetDetailsViewModel(ResponsePetDetails responsePetDetails) {
        this.responsePetDetails = responsePetDetails;
    }

    public void setPetID(long id) {
        responsePetDetails.setDetail(id);
    }

    public LiveData<PetListObject> observeUser() {
        return setDetails;
    }

    public void init() {
        setDetails = responsePetDetails.getLiveData();
    }

}
