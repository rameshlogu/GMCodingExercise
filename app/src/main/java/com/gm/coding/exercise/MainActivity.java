package com.gm.coding.exercise;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.gm.coding.exercise.di.AppModule;
import com.gm.coding.exercise.di.MainActivityModule;
import com.gm.coding.exercise.githubcommits.CommitsView;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    @Named(MainActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    protected FragmentManager mFragmentManager;

    @Inject
    Lazy<CommitsView> mFragmentProvider;

    @Inject
    @Named(AppModule.APPLICATION_CONTEXT)
    protected Context mAppContext;

    @Inject
    @Named(MainActivityModule.ACTIVITY_CONTEXT)
    protected Context mActivityContext;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        addFragment();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void addFragment() {
        CommitsView commitsView =
                (CommitsView) mFragmentManager.findFragmentById(R.id.contentFrame);
        if(commitsView == null) {
            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentFrame,mFragmentProvider.get())
                    .commit();
        }
    }
}
