package com.gm.coding.exercise.data.source.remote;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;
import com.gm.coding.exercise.data.source.DataSource;
import com.gm.coding.exercise.data.source.remote.network.NetworkService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Remote data source which will get the data from API using Retrofit newt work library
 * @author Ramesh Loganathan
 */
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
