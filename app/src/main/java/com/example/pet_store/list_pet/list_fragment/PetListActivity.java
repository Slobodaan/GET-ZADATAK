//package com.example.pet_store.list_pet.list_fragment;
//
//import android.os.Bundle;
//
//import com.example.pet_store.R;
//import com.example.pet_store.base.BaseActivity;
//
//
//import androidx.annotation.Nullable;
//
//public class PetListActivity extends BaseActivity {
//    @Override
//    protected int layoutRes() {
//        return R.layout.activity_pet_store;
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if(savedInstanceState == null)
//            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new PetListFragment()).commit();
//    }
//}
