package com.example.week4daily1homeassignment.model.datasource.rxjava;

import android.util.Log;

import com.example.week4daily1homeassignment.model.user.UserProfile;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserProfileObserver implements Observer<UserProfile> {

    Callback callback;
    UserProfile userProfile = new UserProfile();

    public UserProfileObserver(Callback callback) {
        this.callback = callback;
    }


    @Override
    public void onSubscribe(Disposable d) {
        Log.d("TAG", "onSubscribe: SUBSCRIBING");
    }

    @Override
    public void onNext(UserProfile userProfile) {
        this.userProfile = userProfile;

        Log.d("TAG", "onNext: "
                + userProfile.getItems().get(0).getLogin());
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "onError: ", e);
    }

    @Override
    public void onComplete() {
        callback.onSuccess(userProfile);
    }
}
