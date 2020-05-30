package com.example.pet_store.list_pet.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;

import android.os.Bundle;


import com.example.pet_store.R;


import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
  //  private PetListRecyclerAdapter adapter;
    private CompositeDisposable compositeDisposable;
    private Retrofit retrofit;
  //  private ApiService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_item);
    }




}
