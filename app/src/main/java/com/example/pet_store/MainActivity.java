package com.example.pet_store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;

import android.os.Bundle;

import com.example.pet_store.List.PetList;
import com.example.pet_store.adapter.PetListRecyclerAdapter;
import com.example.pet_store.model.ApiService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PetListRecyclerAdapter adapter;
    private CompositeDisposable compositeDisposable;
    private Retrofit retrofit;
    private ApiService mService;
    private ArrayList<PetList> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_item);
    }




}
