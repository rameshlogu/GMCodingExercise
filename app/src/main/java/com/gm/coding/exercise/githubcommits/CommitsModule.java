package com.gm.coding.exercise.githubcommits;

import com.gm.coding.exercise.di.scope.ScopeActivity;
import com.gm.coding.exercise.di.scope.ScopeFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CommitsModule {

    @ScopeFragment
    @ContributesAndroidInjector
    abstract CommitsView commitsView();

    @ScopeActivity
    @Binds
    abstract CommitsContract.Presenter commitsPresenter(CommitsPresenter presenter);
}
