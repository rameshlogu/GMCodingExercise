package com.gm.coding.exercise.di;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.gm.coding.exercise.MainActivity;
import com.gm.coding.exercise.di.scope.ScopeActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {
    public static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @ScopeActivity
    static FragmentManager activityFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @ScopeActivity
    static Context activityContext(MainActivity activity) {
        return activity.getBaseContext();
    }
}
