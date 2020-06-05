package com.example.pet_store.list_pet_details.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pet_store.R;
import com.example.pet_store.di.ViewModelProviderFactory;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.list_pet_details.galery.GalleryAdapter;
import com.example.pet_store.list_pet_details.viewmodel.PetDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;

public class PetDetailsActivity extends AppCompatActivity {

    GalleryAdapter galleryAdapter;
    private TextView mName;
    private TextView mCategory;
    private TextView mStatus;
    private long id;
    List<String>  photoUrl;
    private PetDetailsViewModel petDetailsViewModel;

    private RecyclerView galleryRecyclerView;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        id = extras.getLong("id");
        setContentView(R.layout.activity_pet_details);
        initComponent();
        petDetailsViewModel = ViewModelProviders.of(this, providerFactory).get(PetDetailsViewModel.class);
        petDetailsViewModel.init();
        galleryRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        galleryRecyclerView.setLayoutManager(mLayoutManager);
        galleryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        petDetailsViewModel.setPetID(id);
        subscribe(this);
    }

    private void subscribe(Context context) {
        petDetailsViewModel.observeUser().observe(this, new Observer<PetListObject>() {
            @Override
            public void onChanged(PetListObject petListObject) {
                mName.setText(petListObject.getName());
                mStatus.setText(petListObject.getStatus());
                galleryAdapter = new GalleryAdapter(getApplicationContext(), (ArrayList<String>) petListObject.getPhotoUrls());
                galleryRecyclerView.setAdapter(galleryAdapter);
            }
        });
    }
    public void initComponent() {
        mName = findViewById(R.id.txtName);
        mCategory = findViewById(R.id.txtNameCategory);
        mStatus = findViewById(R.id.txtStatus);
    }
}
