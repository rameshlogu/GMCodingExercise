package com.gm.coding.exercise.data.source;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;

import java.util.List;

import rx.Observable;

/**
 * Data source interface
 * @author Ramesh Loganathan
 */
public interface DataSource {
    Observable<List<GitHubCommit>> fetchGitHubCommits(String owner, String repo);
}
