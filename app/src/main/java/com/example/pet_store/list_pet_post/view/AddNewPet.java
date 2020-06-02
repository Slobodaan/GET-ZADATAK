package com.example.pet_store.list_pet_post.view;

import android.os.Bundle;

import com.example.pet_store.R;
import com.example.pet_store.di.ViewModelProviderFactory;
import com.example.pet_store.list_pet.viewmodel.PetListViewModel;
import com.example.pet_store.list_pet_post.viewmodel.AddPetViewModel;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;

public class AddNewPet extends AppCompatActivity {

    private AddPetViewModel addPetViewModel;
    @Inject
    ViewModelProviderFactory providerFactory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        addPetViewModel = ViewModelProviders.of(this, providerFactory).get(AddPetViewModel.class);
    }
}
