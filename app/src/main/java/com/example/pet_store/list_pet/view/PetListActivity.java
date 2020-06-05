package com.example.pet_store.list_pet.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pet_store.R;
import com.example.pet_store.di.ViewModelProviderFactory;
import com.example.pet_store.list_pet.adapter.PetListRecyclerAdapter;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.list_pet.viewmodel.PetListViewModel;
import com.example.pet_store.list_pet_post.view.PetPostActivity;
import com.example.pet_store.util.Constants;
import com.getbase.floatingactionbutton.AddFloatingActionButton;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class PetListActivity extends AppCompatActivity {
    PetListRecyclerAdapter petListRecyclerAdapter;
    RecyclerView recyclerView;
    AddFloatingActionButton fab;
    TextView mAvailable;
    TextView mPending;
    TextView mSold;

    private PetListViewModel petListViewModel;
    @Inject
    ViewModelProviderFactory providerFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_store);
        initComponent();
        petListViewModel = ViewModelProviders.of(this, providerFactory).get(PetListViewModel.class);
        petListViewModel.init();
        addPet();
        petListViewModel.setPetList(Constants.AVAILABLE);
        petListRecyclerAdapter = new PetListRecyclerAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        subscribeObservers(this);
    }

    private void subscribeObservers(Context context) {
        petListViewModel.observeList().observe(this, new Observer<List<PetListObject>>() {
            @Override
            public void onChanged(List<PetListObject> petListObjects) {
                petListRecyclerAdapter.updateList((ArrayList<PetListObject>) petListObjects);
                recyclerView.setAdapter(petListRecyclerAdapter);
            }
        });
    }


    public void initComponent() {
        fab = findViewById(R.id.add_pet);
        mAvailable = findViewById(R.id.txtAvailable);
        mPending = findViewById(R.id.txtPending);
        mSold = findViewById(R.id.txtSold);
        recyclerView = findViewById(R.id.recycler_pet_store);
    }

    public void addPet() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(PetListActivity.this, PetPostActivity.class));
                    }
                });
            }
        });
        mAvailable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petListViewModel.setPetList(Constants.AVAILABLE);
                mAvailable.setTextColor(getColor(R.color.app_color));
                mPending.setTextColor(getColor(R.color.colorPrimary));
                mSold.setTextColor(getColor(R.color.colorPrimary));
            }
        });
        mPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petListViewModel.setPetList(Constants.PENDING);
                mAvailable.setTextColor(getColor(R.color.colorPrimary));
                mPending.setTextColor(getColor(R.color.app_color));
                mSold.setTextColor(getColor(R.color.colorPrimary));
            }
        });
        mSold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petListViewModel.setPetList(Constants.SOLD);
                mAvailable.setTextColor(getColor(R.color.colorPrimary));
                mPending.setTextColor(getColor(R.color.colorPrimary));
                mSold.setTextColor(getColor(R.color.app_color));
            }
        });


    }



}
