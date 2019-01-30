package com.example.week4daily1homeassignment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week4daily1homeassignment.model.user.RepoItem;
import com.example.week4daily1homeassignment.model.user.RepositoryResponse;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<RepoItem> repoItems;

    public RecyclerViewAdapter(List<RepoItem> repositories) {
        this.repoItems = repositories;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repository, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        RepoItem repoItem = repoItems.get(position);

        if(repoItem != null) {

            viewHolder.repositoryNameTextView.setText(repoItem.getName());
            viewHolder.repositoryDescriptionTextView.setText(repoItem.getDescription());
            viewHolder.repositoryUrlTextViewId.setText(repoItem.getHtmlUrl());
        }

    }

    @Override
    public int getItemCount() {
        return repoItems != null ? repoItems.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView repositoryNameTextView;
        TextView repositoryDescriptionTextView;
        TextView repositoryUrlTextViewId;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            repositoryNameTextView = itemView.findViewById(R.id.repositoryNameTextViewId);
            repositoryDescriptionTextView = itemView.findViewById(R.id.repositoryDescriptionTextViewId);
            repositoryUrlTextViewId = itemView.findViewById(R.id.repositoryUrlTextViewId);

        }
    }
}
