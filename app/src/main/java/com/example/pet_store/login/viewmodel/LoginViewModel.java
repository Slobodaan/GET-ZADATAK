package com.example.pet_store.login.viewmodel;

import android.util.Log;
import android.view.View;

import com.example.pet_store.login.model.ResponseLogin;
import com.example.pet_store.login.model.LoginResponseObject;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class LoginViewModel extends ViewModel {
    private ResponseLogin responseLogin;

    private static final String TAG = "LoginViewMode";

    private LiveData<LoginResponseObject> loginUser = new MutableLiveData<>();
    public MutableLiveData<String> UserName = new MutableLiveData<>();

    public MutableLiveData<String> Password = new MutableLiveData<>();


    @Inject
    public LoginViewModel(ResponseLogin responseLogin) {

        this.responseLogin = responseLogin;
        //loginUser = responseLogin.
        Log.d(TAG, "LoginViewModel: working radiiii mooolim teeeee");


    }

    //saljem
    public void loginWithUser(String username, String password) {
      loginUser =  responseLogin.registerUser(username,password);

    }
//add
    public LiveData<LoginResponseObject> observeUser() {
        return loginUser;
    }

    public void onClick(View view) {
        // slanje retrofitu
    }


}

