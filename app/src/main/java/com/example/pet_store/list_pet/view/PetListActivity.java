package com.example.pet_store.list_pet.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerAppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pet_store.R;
import com.example.pet_store.di.ViewModelProviderFactory;
import com.example.pet_store.generated.callback.OnClickListener;
import com.example.pet_store.list_pet.adapter.PetListRecyclerAdapter;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.list_pet.viewmodel.PetListViewModel;
import com.example.pet_store.list_pet_post.view.AddNewPet;
import com.getbase.floatingactionbutton.AddFloatingActionButton;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class PetListActivity extends AppCompatActivity {
    PetListRecyclerAdapter petListRecyclerAdapter;
    RecyclerView recyclerView;
    AddFloatingActionButton fab;

    private PetListViewModel petListViewModel;
    @Inject
    ViewModelProviderFactory providerFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pet_store);
        initComponent();
        addIte();
        recyclerView = findViewById(R.id.recycler_pet_store);

        petListViewModel = ViewModelProviders.of(this, providerFactory).get(PetListViewModel.class);
        petListViewModel.setPetList("available");
        subscribeObservers(this);

    }
    private void subscribeObservers(Context context){
        petListViewModel.observeList().observe(this, new Observer<List<PetListObject>>() {
            @Override
            public void onChanged(List<PetListObject> petListObjects) {
                Toast.makeText(context,"radi ", Toast.LENGTH_LONG).show();
                petListRecyclerAdapter = new PetListRecyclerAdapter(context, (ArrayList)petListObjects);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(petListRecyclerAdapter);
            }
        });
    }


    public void initComponent(){
         fab = findViewById(R.id.add_pet);

    }

     private void addIte(){
   fab.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           fab.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(PetListActivity.this, AddNewPet.class));
               }
           });
       }
   });
     }



}
