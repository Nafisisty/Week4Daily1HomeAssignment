package com.example.week4daily1homeassignment.model.datasource.rxjava;

import com.example.week4daily1homeassignment.model.datasource.retrofit.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DatasourceRepo {
    RetrofitHelper retrofitHelper = new RetrofitHelper();

    public void getUserProfile(Callback callback){
        retrofitHelper.getUserProfileOb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new UserProfileObserver(callback));
    }

    public void getRepository(RepoCallback repoCallback) {
        retrofitHelper.getRepositoryOb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RepositoryResponseObserver(repoCallback));
    }
}
