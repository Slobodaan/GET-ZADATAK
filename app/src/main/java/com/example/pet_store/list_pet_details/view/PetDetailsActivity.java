package com.example.pet_store.list_pet_details.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pet_store.R;
import com.example.pet_store.di.ViewModelProviderFactory;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.list_pet.viewmodel.PetListViewModel;
import com.example.pet_store.list_pet_details.viewmodel.PetDetailsViewModel;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;

public class PetDetailsActivity extends AppCompatActivity {

    TextView t;
    private PetDetailsViewModel petDetailsViewModel;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);
       t = findViewById(R.id.txtName);
        petDetailsViewModel = ViewModelProviders.of(this, providerFactory).get(PetDetailsViewModel.class);

        petDetailsViewModel.setPetID(1234567891);
        petDetailsViewModel.init();
        subscribe(this);
    }

    private void subscribe(Context context)
    {
        petDetailsViewModel.observeUser().observe(this, new Observer<PetListObject>() {
            @Override
            public void onChanged(PetListObject petListObject) {
                Toast.makeText(context, "aaaaa", Toast.LENGTH_LONG).show();
            }
        });
    }

}
