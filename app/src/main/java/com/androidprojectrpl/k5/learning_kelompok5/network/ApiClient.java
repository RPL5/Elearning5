package com.androidprojectrpl.k5.learning_kelompok5.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api-learning.puspidep.org/";
    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface;

    private static final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
    public static ApiInterface getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpBuilder.build())
                    .build();
        }

        apiInterface = retrofit.create(ApiInterface.class);

        return apiInterface;
    }
}
