package com.gm.coding.exercise.di;

import com.gm.coding.exercise.MainApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        BindActivityModule.class})
public interface AppComponent extends AndroidInjector<MainApplication> {
    void inject(MainApplication application);
}
