//package com.example.pet_store.login;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import com.example.pet_store.R;
//
//import com.example.pet_store.base.BaseFragment;
//
////import com.example.pet_store.di.pet_list.PetListViewModelModule;
//import com.example.pet_store.list_pet.list_fragment.PetListViewModel1;
//import com.example.pet_store.di.ViewModelProviderFactory;
//
//import javax.inject.Inject;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.lifecycle.ViewModelProviders;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import butterknife.BindView;
//
//public class PetListFragment extends BaseFragment {
//
//    @BindView(R.id.recycler_pet_store)
//    RecyclerView petListView;
//
//    @BindView(R.id.tv_error)
//    TextView errorTextView;
//
//    @BindView(R.id.loading_view)
//    View loadingView;
//
//    @Inject
//    ViewModelProviderFactory viewModelFactoryModule;
//
//    private PetListViewModel1 petListViewModel;
//
//    @Override
//    protected int layoutRes() {
//        return R.layout.fragment_pet_list;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        petListViewModel = ViewModelProviders.of(this, viewModelFactoryModule).get(PetListViewModel1.class);
//
//        petListView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
//        petListView.setAdapter(new PetListRecyclerAdapter(petListViewModel,this ));
//        petListView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        observableViewModel();
//    }
//
//    private void observableViewModel() {
//
//        petListViewModel.getPetList().observe(getViewLifecycleOwner(),petStoreList -> {
//            if(petStoreList !=null)
//                petListView.setVisibility(View.VISIBLE);
//
//        });
//    }
//}
