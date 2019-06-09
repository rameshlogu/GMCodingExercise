package com.gm.coding.exercise.data.source.remote.network;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface NetworkService {
    @GET("repos/{owner}/{repo}/commits")
    Observable<List<GitHubCommit>> getGithubCommits(@Path("owner") String owner, @Path("repo") String repo);
}
