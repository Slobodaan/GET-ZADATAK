package com.example.pet_store.list_pet.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.pet_store.R;
import com.example.pet_store.list_pet.model.PetListObject;
import com.example.pet_store.list_pet_details.view.PetDetailsActivity;
import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetListRecyclerAdapter extends RecyclerView.Adapter<PetListRecyclerAdapter.PetListViewHolder> {

    ArrayList<PetListObject> petArrayList;
    Context context;

    public PetListRecyclerAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public PetListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new PetListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetListViewHolder holder, int position) {
        PetListObject petList = petArrayList.get(position);
        PetListViewHolder viewHolder = holder;
        viewHolder.mName.setText(petList.getName());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PetDetailsActivity.class);
                intent.putExtra("id", petArrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return petArrayList.size();
    }

    public static class PetListViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private LinearLayout parent;

        public PetListViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name_pet);
            parent = itemView.findViewById(R.id.parent_layout);
        }
    }

    public void updateList(ArrayList<PetListObject> list) {
        this.petArrayList = list;
        notifyDataSetChanged();
    }
}
