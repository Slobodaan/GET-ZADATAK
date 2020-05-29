package com.example.pet_store.network.pet_list;

import com.example.pet_store.model.PetStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PetRepository {

    private final PetService petService;

    @Inject
    public PetRepository(PetService petService) {

    this.petService =petService;

}

    public Single<List<PetStore>> getRepositories() {
        return petService.getRepositories();
    }
}
