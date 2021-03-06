package com.example.pet_store.di.component;


import com.example.pet_store.base.BaseApplication;
import com.example.pet_store.di.AppModule;
import com.example.pet_store.di.modul.ActivityBuildersModule;
import com.example.pet_store.di.modul.ContextModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules =  {
                ContextModule.class,
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class, }
)

public interface AppComponent  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(BaseApplication baseApplication);
        AppComponent build();
        }

    void inject(BaseApplication app);

}
