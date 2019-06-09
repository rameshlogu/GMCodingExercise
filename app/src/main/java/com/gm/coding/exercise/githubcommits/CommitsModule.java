package com.gm.coding.exercise.githubcommits;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gm.coding.exercise.MainActivity;
import com.gm.coding.exercise.di.scope.ScopeActivity;
import com.gm.coding.exercise.di.scope.ScopeFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CommitsModule {

    @ScopeFragment
    @ContributesAndroidInjector
    abstract CommitsView commitsView();

    @ScopeActivity
    @Binds
    abstract CommitsContract.Presenter commitsPresenter(CommitsPresenter presenter);

    @ScopeActivity
    @Provides
    static CommitsListAdaptor commitsListAdaptor(){
        return new CommitsListAdaptor();
    }

    @ScopeActivity
    @Provides
    static RecyclerView.LayoutManager commitsListLayoutManager(MainActivity activity){
        return new LinearLayoutManager(activity);
    }
}
