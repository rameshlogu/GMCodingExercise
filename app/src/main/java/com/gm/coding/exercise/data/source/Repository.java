package com.gm.coding.exercise.data.source;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class Repository implements DataSource {
    private DataSource mRemoteDataSource;

    @Inject
    Repository(DataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<GitHubCommit>> fetchGitHubCommits(String owner, String repo) {
        //Fetch always from API for now.
        // Basically, the availability of in-memory/local data source
        // check will be made here if required in future.
        return fetchGitHubCommitsFromAPI(owner,repo);
    }

    private Observable<List<GitHubCommit>> fetchGitHubCommitsFromAPI(String owner, String repo) {
        return mRemoteDataSource.fetchGitHubCommits(owner,repo);
    }
}
