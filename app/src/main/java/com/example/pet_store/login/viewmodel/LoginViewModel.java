package com.example.pet_store.login.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pet_store.Repository.ResponseLogin;
import com.example.pet_store.login.model.LoginResponseObject;

import java.util.Objects;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class LoginViewModel extends ViewModel {
    private ResponseLogin responseLogin;

    private static final String TAG = "LoginViewMode";
    private LiveData<LoginResponseObject> loginUser = new MutableLiveData<>();
    public MutableLiveData<String> UserName = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>() ;


    @Inject
    public LoginViewModel(ResponseLogin responseLogin) {
        this.responseLogin = responseLogin;
    }

    public void loginWithUser(String username, String password) {
        responseLogin.registerUser(username, password);
    }

    public LiveData<LoginResponseObject> observeUser() {
        return loginUser;
    }

    public void onClick(View view) {
       if(TextUtils.isEmpty(UserName.getValue())){
           Toast.makeText(view.getContext(),"Enter an Username",Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(Password.getValue())){
           Toast.makeText(view.getContext(),"Enter a Password",Toast.LENGTH_LONG).show();
       }else{
           loginWithUser(UserName.getValue(), Password.getValue());
       }

    }

    public void init() {
        loginUser = responseLogin.getLiveData();
    }
}




