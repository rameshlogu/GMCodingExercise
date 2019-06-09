package com.gm.coding.exercise.di;

import com.gm.coding.exercise.MainActivity;
import com.gm.coding.exercise.di.scope.ScopeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This is used by Dagger to inject the activities
 *
 * @author Ramesh Loganathan
 */
@Module
abstract class BindActivityModule {
    @ScopeActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}
