package com.gm.coding.exercise.di;

import com.gm.coding.exercise.MainActivity;
import com.gm.coding.exercise.di.scope.ScopeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class BindActivityModule {
    @ScopeActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}
