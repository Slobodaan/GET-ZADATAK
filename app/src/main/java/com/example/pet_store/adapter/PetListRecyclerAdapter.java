package com.example.pet_store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pet_store.List.PetList;
import com.example.pet_store.R;
import com.example.pet_store.login.PetListViewModel;
import com.example.pet_store.model.PetStore;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PetListRecyclerAdapter extends RecyclerView.Adapter<PetListRecyclerAdapter.MyViewHolder> {

   // private ArrayList<PetStore> mList;
    private  List<PetStore> mList = new ArrayList<>();
    private Context context;

    public PetListRecyclerAdapter(PetListViewModel petListViewModel, LifecycleOwner lifecycleOwner){
       petListViewModel.getPetList().observe(lifecycleOwner,petStores -> {
           mList.clear();
           if(petStores !=null){
               mList.addAll(petStores);
               notifyDataSetChanged();
           }
       });

        setHasStableIds(true);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);

        return new PetListRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{

        @BindView(R.id.name_pet) TextView name;
        @BindView(R.id.name_category) TextView name_category;

         private PetStore petStore;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
        void bind(PetStore petStore) {
            this.petStore = petStore;
            name.setText(petStore.name);
            name_category.setText(petStore.description);

        }
    }


}
