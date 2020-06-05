package com.example.pet_store.Repository;

import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.network.ServerApi;
import javax.inject.Inject;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponsePetDetails {

    private ServerApi serverApi;
    private MutableLiveData<PetListObject> liveData;

    @Inject
    public ResponsePetDetails(ServerApi serverApi) {

        this.serverApi = serverApi;
        liveData = new MutableLiveData<>();
    }

    public void setDetail(long id) {
        Call<PetListObject> responseDetails = serverApi.detailsPet(id);
        responseDetails.enqueue(new Callback<PetListObject>() {
            @Override
            public void onResponse(Call<PetListObject> call, Response<PetListObject> response) {
                PetListObject object = response.body();
                liveData.postValue(object);
            }
            @Override
            public void onFailure(Call<PetListObject> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    public MutableLiveData<PetListObject> getLiveData() {
        return liveData;
    }
}