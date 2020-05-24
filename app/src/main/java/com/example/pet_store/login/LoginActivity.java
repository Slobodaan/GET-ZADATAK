package com.example.pet_store.login;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.example.pet_store.R;
import com.example.pet_store.models.User;
import com.example.pet_store.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity implements View.OnClickListener {
    private EditText userId;
    private LoginViewModel loginViewModel;
    private static final String TAG = "AuthActivity";
    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userId = findViewById(R.id.etPassword);
        findViewById(R.id.buttonLogin).setOnClickListener(this);
        loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        setLogo();
        subscribeObservers();
    }

    private void subscribeObservers(){
        loginViewModel.observeUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user != null){
                    Log.d(TAG, "onChanged: " + user.getUsername());
                }
            }
        });
    }

    private void setLogo() {
        requestManager.load(logo)
                .into((ImageView) findViewById((R.id.login_logo)));
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        loginViewModel.loginWithId(Integer.parseInt(userId.getText().toString()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonLogin: {
                attemptLogin();
                break;
            }
        }

    }
}
