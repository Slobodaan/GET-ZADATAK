package com.example.pet_store.list_pet.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pet_store.R;
import com.example.pet_store.list_pet.model.PetListObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetListRecyclerAdapter extends RecyclerView.Adapter<PetListRecyclerAdapter.PetListViewHolder> {

    ArrayList<PetListObject> petArrayList;
    Context context;
    public PetListRecyclerAdapter(Context context, List<PetListObject> petArrayList)
    {
        this.context = context;
        this.petArrayList = (ArrayList<PetListObject>) petArrayList;
    }
    @NonNull
    @Override
    public PetListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.recycler_item ,parent,false);
        return new PetListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetListViewHolder holder, int position) {
       PetListObject petList = petArrayList.get(position);
       PetListViewHolder viewHolder = holder;
       viewHolder.mName.setText(petList.getName());
       viewHolder.mCategoryName.setText(petList.getCategory().getName());
    }

    @Override
    public int getItemCount() {
        return petArrayList.size();
    }

    public static class PetListViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mCategoryName;
        public PetListViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name_pet);
            mCategoryName = itemView.findViewById(R.id.name_category);
        }
    }
}
