package com.gm.coding.exercise.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {
    public static final String APPLICATION_CONTEXT = "Application.Context";
    @Binds
    @Named(APPLICATION_CONTEXT)
    abstract Context bindContext(Application application);
}
