package com.gm.coding.exercise.di;

import android.app.Application;
import android.content.Context;

import com.gm.coding.exercise.data.source.RepositoryModule;
import com.gm.coding.exercise.data.source.remote.network.NetworkModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module(includes = {RepositoryModule.class, NetworkModule.class})
public abstract class AppModule {
    public static final String APPLICATION_CONTEXT = "Application.Context";

    @Binds
    @Named(APPLICATION_CONTEXT)
    abstract Context bindContext(Application application);
}
