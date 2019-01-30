package com.example.week4daily1homeassignment.model.datasource.rxjava;

import com.example.week4daily1homeassignment.model.user.RepositoryResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RepositoryResponseObserver implements Observer<RepositoryResponse> {

    RepoCallback repoCallback;
    RepositoryResponse repositoryResponse = new RepositoryResponse();

    public RepositoryResponseObserver(RepoCallback repoCallback) {
        this.repoCallback = repoCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(RepositoryResponse repositoryResponse) {
        this.repositoryResponse = repositoryResponse;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        repoCallback.onSuccess(repositoryResponse);
    }
}
