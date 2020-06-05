package com.example.pet_store.list_pet_post.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pet_store.R;
import com.example.pet_store.databinding.ActivityPetPostBinding;
import com.example.pet_store.di.ViewModelProviderFactory;
import com.example.pet_store.list_pet_post.viewmodel.PetPostViewModel;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;

public class PetPostActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mPhotos;
    private Button mAdd;
    private Spinner mCategory;
    private ActivityPetPostBinding binding;
    private PetPostViewModel addPetViewModel;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pet_post);
        addPetViewModel = ViewModelProviders.of(this, providerFactory).get(PetPostViewModel.class);
    }
}