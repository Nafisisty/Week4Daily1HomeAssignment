package com.example.week4daily1homeassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.week4daily1homeassignment.model.datasource.rxjava.Callback;
import com.example.week4daily1homeassignment.model.datasource.rxjava.DatasourceRepo;
import com.example.week4daily1homeassignment.model.datasource.rxjava.RepoCallback;
import com.example.week4daily1homeassignment.model.user.RepoItem;
import com.example.week4daily1homeassignment.model.user.RepositoryResponse;
import com.example.week4daily1homeassignment.model.user.UserProfile;

import java.util.List;

public class RepositoryList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);

        recyclerView = findViewById(R.id.recyclerViewId);

        DatasourceRepo datasourceRepo = new DatasourceRepo();
        datasourceRepo.getRepository(new RepoCallback() {
            @Override
            public void onSuccess(RepositoryResponse repositoryResponse) {
                Log.d("TAG_RX", "onSuccess: " + repositoryResponse.getItems().get(0).getName());

                List<RepoItem> repoItemList = repositoryResponse.getItems();

                recyclerViewAdapter = new RecyclerViewAdapter(repoItemList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });

    }
}
