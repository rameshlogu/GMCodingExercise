package com.gm.coding.exercise.githubcommits;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gm.coding.exercise.R;
import com.gm.coding.exercise.di.MainActivityModule;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class CommitsView extends Fragment implements HasSupportFragmentInjector, CommitsContract.View {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    @Named(MainActivityModule.ACTIVITY_CONTEXT)
    protected Context mActivityContext;

    @Inject
    protected CommitsPresenter mPresenter;

    @Inject
    public CommitsView(){}

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.commits_view,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.fetchCommits();
        Toast.makeText(mActivityContext,"****** onResume fragment ******",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showCommits() {

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
