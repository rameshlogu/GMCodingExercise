package com.gm.coding.exercise.di;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.gm.coding.exercise.MainActivity;
import com.gm.coding.exercise.di.scope.ScopeActivity;
import com.gm.coding.exercise.githubcommits.CommitsModule;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * This is used by Dagger to inject the required arguments
 * and Activity{@link com.gm.coding.exercise.MainActivity}
 */
@Module(includes = CommitsModule.class)
public abstract class MainActivityModule {
    public static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";
    public static final String ACTIVITY_CONTEXT = "Activity.Context";

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @ScopeActivity
    static FragmentManager activityFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @Named(ACTIVITY_CONTEXT)
    @ScopeActivity
    static Context activityContext(MainActivity activity) {
        return activity.getBaseContext();
    }
}
