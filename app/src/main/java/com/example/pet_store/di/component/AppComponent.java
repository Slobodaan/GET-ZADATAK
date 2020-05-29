package com.example.pet_store.di.component;


import android.app.Application;

import com.example.pet_store.base.BaseApplication;
import com.example.pet_store.di.AppModule;
import com.example.pet_store.di.modul.ActivityBuildersModule;
import com.example.pet_store.di.modul.ContextModule;
import com.example.pet_store.di.modul.ViewModelFactoryModule;

import javax.inject.Singleton;

import androidx.core.content.ContextCompat;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules =  {
                ContextModule.class,
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class, }
)

public interface AppComponent extends AndroidInjector<BaseApplication> {
        void inject(BaseApplication application);
        @Component.Builder
        interface Builder{
                @BindsInstance
                Builder application(Application application);
                AppComponent build();
        }

}
