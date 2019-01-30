package com.example.week4daily1homeassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4daily1homeassignment.model.datasource.rxjava.Callback;
import com.example.week4daily1homeassignment.model.datasource.rxjava.DatasourceRepo;
import com.example.week4daily1homeassignment.model.user.UserProfile;

public class MainActivity extends AppCompatActivity {


    ImageView userImageView;
    TextView userNameTextView, userTypeTextView, userScoreTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userImageView = findViewById(R.id.userImageViewId);
        userNameTextView = findViewById(R.id.userNameTextViewId);
        userTypeTextView = findViewById(R.id.userTypeTextViewId);
        userScoreTextView = findViewById(R.id.userScoreTextViewId);

        DatasourceRepo datasourceRepo = new DatasourceRepo();
        datasourceRepo.getUserProfile(new Callback() {
            @Override
            public void onSuccess(UserProfile userProfile) {
                Log.d("TAG_RX", "onSuccess: " + userProfile.getItems().get(0).getLogin());

                Glide.with(userImageView)
                        .load(userProfile.getItems().get(0).getAvatarUrl())
                        .into(userImageView);

                userNameTextView.setText(userProfile.getItems().get(0).getLogin());
                userTypeTextView.setText(userProfile.getItems().get(0).getType());
                userScoreTextView.setText(userProfile.getItems().get(0).getScore().toString());
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RepositoryList.class);
        startActivity(intent);
    }
}
