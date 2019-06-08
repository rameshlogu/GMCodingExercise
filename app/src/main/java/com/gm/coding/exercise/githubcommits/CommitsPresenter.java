package com.gm.coding.exercise.githubcommits;

import com.gm.coding.exercise.di.scope.ScopeActivity;

import javax.inject.Inject;

@ScopeActivity
public class CommitsPresenter implements CommitsContract.Presenter {

    private CommitsContract.View mView;

    @Inject
    CommitsPresenter(){}

    @Override
    public void attachView(CommitsContract.View view) {
        mView = view;
    }

    @Override
    public void fetchCommits() {

    }

}
