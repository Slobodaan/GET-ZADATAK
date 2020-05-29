package com.example.pet_store.login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.example.pet_store.List.PetList;
import com.example.pet_store.MainActivity;
import com.example.pet_store.R;
import com.example.pet_store.databinding.ActivityLoginBinding;
import com.example.pet_store.model.User;
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
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        setLogo();

        subscribeObservers();
    }

    private void subscribeObservers(){
        loginViewModel.observeUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {

            }
        });
    }

    private void setLogo() {
        requestManager.load(logo)
                .into((ImageView) findViewById((R.id.login_logo)));
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
