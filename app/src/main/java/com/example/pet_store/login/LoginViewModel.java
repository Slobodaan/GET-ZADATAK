package com.example.pet_store.login;

import android.util.Log;

import com.example.pet_store.models.User;
import com.example.pet_store.network.login.LoginApi;

import javax.inject.Inject;

import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.Observer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.schedulers.Schedulers;


public class LoginViewModel extends ViewModel {

     private static final String TAG = "LoginViewMode";
    private MediatorLiveData<User> loginUser = new MediatorLiveData<>();
     private final LoginApi loginApi;
     @Inject
    public LoginViewModel(LoginApi loginApi){
       this.loginApi = loginApi;
         Log.d(TAG,"LoginViewModel: working radiiii mooolim teeeee" );


         }
    public void loginWithId(int userId){
        final LiveData<User> source =
                LiveDataReactiveStreams.fromPublisher(
                loginApi.getUser(userId)
                        .subscribeOn(Schedulers.io()));

        loginUser.addSource(source, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                loginUser.setValue(user);
                loginUser.removeSource(source);
            }
        });
    }

    public LiveData<User> observeUser(){
        return loginUser;
    }

    }

