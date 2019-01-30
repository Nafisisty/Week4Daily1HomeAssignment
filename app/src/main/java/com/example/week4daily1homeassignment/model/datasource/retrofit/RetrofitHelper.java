package com.example.week4daily1homeassignment.model.datasource.retrofit;

import com.example.week4daily1homeassignment.model.datasource.okhttp.OkHttpHelper;
import com.example.week4daily1homeassignment.model.user.RepositoryResponse;
import com.example.week4daily1homeassignment.model.user.UserProfile;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4daily1homeassignment.model.Constants.ACTUAL_BASE_URL;
import static com.example.week4daily1homeassignment.model.Constants.PATH_FOR_REPOSITORIES;
import static com.example.week4daily1homeassignment.model.Constants.PATH_FOR_USERPROFILE;
import static com.example.week4daily1homeassignment.model.Constants.QUERY_RESULTS;

public class RetrofitHelper {

    public static Retrofit createRetrofitForRx() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ACTUAL_BASE_URL)
                .client(OkHttpHelper.okhttpWithIntercepterClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<RepositoryResponse> getRepositoryOb() {
        Retrofit retrofit = createRetrofitForRx();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getRepositoryObservable("user:Nafisisty");
    }


    public static Observable<UserProfile> getUserProfileOb() {
        Retrofit retrofit = createRetrofitForRx();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getUserProfileObservable("user:Nafisisty");
    }

    public interface RemoteService {
        @GET(PATH_FOR_USERPROFILE)
        Observable<UserProfile> getUserProfileObservable(@Query(QUERY_RESULTS) String userName);

        @GET(PATH_FOR_REPOSITORIES)
        Observable<RepositoryResponse> getRepositoryObservable(@Query(QUERY_RESULTS) String userName);

    }

}
