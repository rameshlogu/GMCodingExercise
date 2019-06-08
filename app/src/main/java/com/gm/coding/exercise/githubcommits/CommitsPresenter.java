package com.gm.coding.exercise.githubcommits;

import android.util.Log;

import com.gm.coding.exercise.data.network.NetworkService;
import com.gm.coding.exercise.di.scope.ScopeActivity;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@ScopeActivity
public class CommitsPresenter implements CommitsContract.Presenter {

    private CommitsContract.View mView;

    @Inject
    NetworkService mService;

    @Inject
    CommitsPresenter(){}

    @Override
    public void attachView(CommitsContract.View view) {
        mView = view;
    }

    @Override
    public void fetchCommits() {
        mService.getGithubCommits("prolificinteractive","material-calendarview").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        Log.d(CommitsPresenter.class.getName(),"service onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(CommitsPresenter.class.getName(),"service onError");
                    }

                    @Override
                    public void onNext(Object object) {
                        Log.d(CommitsPresenter.class.getName(),"service onNext "+object);
                    }
                });
    }

}
