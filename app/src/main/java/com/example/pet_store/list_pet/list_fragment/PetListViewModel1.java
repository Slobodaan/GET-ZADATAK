//package com.example.pet_store.list_pet.list_fragment;
//
//import com.example.pet_store.List.PetList;
//import com.example.pet_store.model.PetStore;
//
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.observers.DisposableSingleObserver;
//import io.reactivex.schedulers.Schedulers;
//
//public class PetListViewModel1 extends ViewModel {
//
//  //  private final PetRepository petRepository;
//    private CompositeDisposable compositeDisposable;
//
//    public final MutableLiveData<List<PetStore>> petList = new MutableLiveData<>();
//    public final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
//    public final MutableLiveData<Boolean> loading = new MutableLiveData<>();
//
////    @Inject
////    public PetListViewModel1(PetRepository petRepository){
////        this.petRepository = petRepository;
////        compositeDisposable = new CompositeDisposable();
////
////        fetchList();
////
////
////    }
//    public LiveData<List<PetStore>> getPetList() {
//        return petList;
//    }
//   public  LiveData<Boolean> getError() {
//        return repoLoadError;
//    }
//    public LiveData<Boolean> getLoading() {
//        return loading;
//    }
//
//
////    private void fetchList(){
////        loading.setValue(true);
////  //      compositeDisposable.add(petRepository.getRepositories().
////           subscribeOn(Schedulers.io())
////
////                       .subscribeWith(new DisposableSingleObserver<List<PetStore>>() {
////                    @Override
////                    public void onSuccess(List<PetStore> value) {
////                        repoLoadError.setValue(false);
////                        petList.setValue(value);
////                        loading.setValue(false);
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////
////                    }
////                }));
////
////    }
//
//
//    @Override
//    protected void onCleared() {
//        super.onCleared();
//        if (compositeDisposable != null) {
//            compositeDisposable.clear();
//            compositeDisposable = null;
//        }
//    }
//
//
//}
