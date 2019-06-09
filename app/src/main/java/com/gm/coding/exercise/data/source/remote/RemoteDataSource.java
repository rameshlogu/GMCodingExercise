package com.gm.coding.exercise.data.source.remote;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;
import com.gm.coding.exercise.data.source.DataSource;
import com.gm.coding.exercise.data.source.remote.network.NetworkService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class RemoteDataSource implements DataSource {

    @Inject
    NetworkService mService;

    @Inject
    RemoteDataSource(){}

    @Override
    public Observable<List<GitHubCommit>> fetchGitHubCommits(String owner, String repo) {
        return mService.getGithubCommits(owner,repo);
    }
}
