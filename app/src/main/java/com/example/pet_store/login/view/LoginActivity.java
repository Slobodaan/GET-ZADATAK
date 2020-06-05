package com.example.pet_store.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pet_store.list_pet.view.PetListActivity;
import com.example.pet_store.R;
import com.example.pet_store.databinding.ActivityLoginBinding;
import com.example.pet_store.login.viewmodel.LoginViewModel;
import com.example.pet_store.login.model.LoginResponseObject;
import com.example.pet_store.di.ViewModelProviderFactory;
import javax.inject.Inject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;
    private static final String TAG = "LoginActivity";
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel =   ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        loginViewModel.init();
        subscribeObservers(this);
    }

    private void subscribeObservers(Context context){
        loginViewModel.observeUser().observe(this, new Observer<LoginResponseObject>() {
            @Override
            public void onChanged(LoginResponseObject user) {
                    attemptLogin();
            }
        });
    }
    private void attemptLogin() {
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
        finish();
    }

}
