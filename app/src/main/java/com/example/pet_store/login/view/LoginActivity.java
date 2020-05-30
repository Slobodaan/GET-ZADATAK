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
import com.example.pet_store.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity implements View.OnClickListener {
    private EditText etEmail;
    private  EditText etPassword;
    private Button btnLogin;

    private ActivityLoginBinding binding;

    private LoginViewModel loginViewModel;

    private static final String TAG = "LoginActivity";



    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel =   ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        loginViewModel.loginWithUser("abc","");
        subscribeObservers(this);

    }

    private void subscribeObservers(Context context){
        loginViewModel.observeUser().observe(this, new Observer<LoginResponseObject>() {
            @Override
            public void onChanged(LoginResponseObject user) {
             attemptLogin();
                Toast.makeText(context,"radi", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void attemptLogin() {
//        if(TextUtils.isEmpty(etEmail.getText().toString())){
//            return;
//        }
//        loginViewModel.loginWithUser(etEmail.getText().toString(),etPassword.getText().toString());
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
        finish();

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
        finish();

            }
}
