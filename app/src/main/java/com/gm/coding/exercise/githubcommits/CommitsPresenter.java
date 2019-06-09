package com.gm.coding.exercise.githubcommits;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;
import com.gm.coding.exercise.data.source.Repository;
import com.gm.coding.exercise.di.scope.ScopeActivity;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Presenter implementation
 * @author Ramesh Loganathan
 */
@ScopeActivity
public class CommitsPresenter implements CommitsContract.Presenter {

    private CommitsContract.View mView;

    @Inject
    Repository mRepository;

    private static final String OWNER = "flutter";
    private static final String REPO = "flutter";

    @Inject
    CommitsPresenter(){}

    @Override
    public void attachView(CommitsContract.View view) {
        mView = view;
    }

    @Override
    public void fetchCommits() {
        mView.showLoading();
        mRepository.fetchGitHubCommits(OWNER,REPO)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitHubCommit>>() {
                    @Override
                    public void onCompleted() {
                        mView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideLoading();
                    }

                    @Override
                    public void onNext(List<GitHubCommit> gitHubCommits) {
                        mView.hideLoading();
                        mView.showCommits(gitHubCommits);
                    }
                });
    }

}
