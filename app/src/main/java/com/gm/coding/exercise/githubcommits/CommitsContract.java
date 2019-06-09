package com.gm.coding.exercise.githubcommits;

import com.gm.coding.exercise.data.githubcommits.GitHubCommit;

import java.util.List;

public interface CommitsContract {
    interface View {
        void showLoading();
        void hideLoading();
        void showCommits(List<GitHubCommit> commits);
    }

    interface Presenter {
        void attachView(View view);
        void fetchCommits();
    }
}
