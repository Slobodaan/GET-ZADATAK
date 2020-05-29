package com.example.pet_store.login;

import android.util.Log;
import android.view.View;

import com.example.pet_store.model.User;
import com.example.pet_store.network.login.LoginApi;

import javax.inject.Inject;

import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.schedulers.Schedulers;


public class LoginViewModel extends ViewModel {

     private static final String TAG = "LoginViewMode";
     private MutableLiveData<User> loginUser = new MutableLiveData<>();

    public MutableLiveData<String> UserName = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

     private final LoginApi loginApi;

     @Inject
    public LoginViewModel(LoginApi loginApi){
       this.loginApi = loginApi;
         Log.d(TAG,"LoginViewModel: working radiiii mooolim teeeee" );


         }
    public void loginWithUser(String username, String password){
     //   final LiveData<User> source =

    }

    public LiveData<User> observeUser(){
        return loginUser;
    }
    public void onClick(View view){}
    // slanje retrofitu

    }

