package com.example.bookstore.logic.remote;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRetrofit {
    final private static String baseurl = "https://yts.lt/api/v2/";

    private static NetRetrofit instance = new NetRetrofit();

    private static Retrofit retrofit;
    public static NetRetrofit getInstance() {
        initRetrofit();
        return instance;
    }

    public static void initRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}

class CustomHttpLogging implements HttpLoggingInterceptor.Logger {

    @Override
    public void log(@NotNull String s) {

    }
}