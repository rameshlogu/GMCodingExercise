package com.gm.coding.exercise.githubcommits;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;
import com.gm.coding.exercise.data.source.Repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class CommitsPresenterTest {

    private CommitsPresenter commitsPresenter;
    @Mock
    public Repository repository;
    @Mock
    CommitsContract.View view;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
//        repository = Mockito.mock(Repository.class);
        commitsPresenter = new CommitsPresenter();
        commitsPresenter.attachView(view);
        commitsPresenter.mRepository = repository;
        commitsPresenter.mainScheduler = Schedulers.immediate();;
    }

    @Test
    public void testFetchCommits() {
//        Mockito.doReturn(Observable.just(Mockito.anyList())).when(repository).fetchGitHubCommits(Mockito.anyString(),Mockito.anyString());
        List<GitHubCommit> listMock = new ArrayList<>();
        Mockito.when(repository.fetchGitHubCommits(Mockito.anyString(),Mockito.anyString())).thenReturn(Observable.just(listMock));
        commitsPresenter.fetchCommits();

        Mockito.verify(view).showLoading();
    }
}