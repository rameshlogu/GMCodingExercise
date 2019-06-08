package com.gm.coding.exercise.githubcommits;

public interface CommitsContract {
    interface View {
        void showLoading();
        void hideLoading();
        void showCommits();
    }

    interface Presenter {
        void attachView(View view);
        void fetchCommits();
    }
}
