package com.gm.coding.exercise.githubcommits;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gm.coding.exercise.R;
import com.gm.coding.exercise.data.githubcommits.GitHubCommit;
import com.gm.coding.exercise.di.MainActivityModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * View implementation using Fragment
 * @author Ramesh Loganathan
 */
public class CommitsView extends Fragment implements HasSupportFragmentInjector, CommitsContract.View {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    @Named(MainActivityModule.ACTIVITY_CONTEXT)
    protected Context mActivityContext;

    @Inject
    protected CommitsPresenter mPresenter;

    @Inject
    protected CommitsListAdaptor mCommitsListAdaptor;

    @Inject
    RecyclerView.LayoutManager mLayoutManager;

    @Inject
    public CommitsView(){}

    @BindView(R.id.recycler_view_commits)
    RecyclerView mCommitsListView;

    @BindView(R.id.progress_circular_commits)
    View mProgressbar;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commits_view,container,false);
        initializeViews(view);
        mPresenter.fetchCommits();
        return view;
    }

    @Override
    public void showLoading() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void showCommits(List<GitHubCommit> commits) {
        mCommitsListAdaptor.setCommitList(commits);
        mCommitsListAdaptor.notifyDataSetChanged();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    private void initializeViews(View parent) {
        //Bind views
        ButterKnife.bind(this,parent);
        //Set up the list view
        mCommitsListAdaptor.setCommitList(new ArrayList<GitHubCommit>());
        mCommitsListView.setAdapter(mCommitsListAdaptor);
        mCommitsListView.setLayoutManager(mLayoutManager);
    }
}
