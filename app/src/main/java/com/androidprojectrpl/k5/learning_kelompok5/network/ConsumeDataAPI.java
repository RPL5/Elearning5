package com.androidprojectrpl.k5.learning_kelompok5.network;

public class ConsumeDataAPI{

    public static ApiInterface getApiService(){
        return ApiClient.getClient().create(ApiInterface.class);
    }
}
