package com.example.pet_store.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pet_store.MainActivity;
import com.example.pet_store.R;
import com.example.pet_store.databinding.ActivityLoginBinding;
import com.example.pet_store.login.viewmodel.LoginViewModel;
import com.example.pet_store.model.LoginResponseObject;
import com.example.pet_store.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel =   ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        loginViewModel.loginWithUser("abc","b");
        subscribeObservers(this);

    }

    private void subscribeObservers(Context context){
        loginViewModel.observeUser().observe(this, new Observer<LoginResponseObject>() {
            @Override
            public void onChanged(LoginResponseObject user) {
                Toast.makeText(context,"radi", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void attemptLogin() {
        if(TextUtils.isEmpty(etEmail.getText().toString())){
            return;
        }
        loginViewModel.loginWithUser(etEmail.getText().toString(),etPassword.getText().toString());

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

            }
}
