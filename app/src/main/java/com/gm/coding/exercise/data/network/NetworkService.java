package com.gm.coding.exercise.data.network;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface NetworkService {
    @GET("repos/{owner}/{repo}/commits")
    Observable<Object> getGithubCommits(@Path("owner") String owner, @Path("repo") String repo);
}
