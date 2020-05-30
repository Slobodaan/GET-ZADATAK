package com.example.pet_store.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.pet_store.R;
import com.example.pet_store.login.model.ResponseLogin;
import com.example.pet_store.model.ApiService;
import com.example.pet_store.network.login.ServerApi;
import com.example.pet_store.network.pet_list.PetService;
import com.example.pet_store.util.Constants;

import javax.inject.Singleton;

import androidx.core.content.ContextCompat;
import dagger.Module;
import dagger.Provides;
import retrofit.converter.JacksonConverter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Module
public class AppModule {

    @Singleton
    @Provides
     static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static ServerApi provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ServerApi.class);
    }
    @Singleton
    @Provides
    static ResponseLogin provideRetrofitResponse(ServerApi serverApi) {
        return new ResponseLogin(serverApi);
    }

}
