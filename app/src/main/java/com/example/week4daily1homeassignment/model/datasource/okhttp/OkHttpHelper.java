package com.example.week4daily1homeassignment.model.datasource.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpHelper {

    public static OkHttpClient okhttpWithIntercepterClient() {
        HttpLoggingInterceptor httpLoggingInterceptor
                = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

}
