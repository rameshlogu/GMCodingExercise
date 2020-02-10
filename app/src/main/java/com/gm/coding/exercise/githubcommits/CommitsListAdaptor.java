package com.gm.coding.exercise.githubcommits;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gm.coding.exercise.R;
import com.gm.coding.exercise.data.githubcommits.GitHubCommit;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Data adaptor for the Recycler view along with the View holder
 * @author Ramesh Loganathan
 */
public class CommitsListAdaptor extends RecyclerView.Adapter<CommitsListAdaptor.CommitViewHolder> {

    private List<GitHubCommit> commitList;

    @Inject
    CommitsListAdaptor(){}

    @NonNull
    @Override
    public CommitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.commit_item, viewGroup, false);
        return new CommitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommitViewHolder commitViewHolder, int i) {
        commitViewHolder.bind(commitList.get(i));
    }

    @Override
    public int getItemCount() {
        return commitList.size();
    }

    void setCommitList(List<GitHubCommit> commitList) {
        this.commitList = commitList;
    }

    /**
     * View holder which will hold the row items of recycler view
     */
    static class CommitViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_commit_author)
        TextView tvAuthor;
        @BindView(R.id.txt_commit_sha)
        TextView tvCommitSha;
        @BindView(R.id.txt_commit_message)
        TextView tvCommitMessage;
        @BindString(R.string.commit)
        String commitLabel;
        @BindView(R.id.image_commit_author)
        ImageView autherImage;

        CommitViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }

        private void bind(GitHubCommit gitHubCommit) {
            tvAuthor.setText(gitHubCommit.commit.author.name);
            tvCommitSha.setText(String.format("%s%s", commitLabel, gitHubCommit.sha));
            tvCommitMessage.setText(gitHubCommit.commit.message);
            Picasso.get().load(gitHubCommit.committer.avathaUrl).into(autherImage);
        }
    }
}
