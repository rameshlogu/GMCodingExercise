package com.gm.coding.exercise.di;

import com.gm.coding.exercise.MainApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        BindActivityModule.class})
public interface AppComponent extends AndroidInjector<MainApplication> {
    void inject(MainApplication application);
}
