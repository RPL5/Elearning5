package com.androidprojectrpl.k5.learning_kelompok5.network;

import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.google.gson.JsonObject;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiInterface {

    @POST("api/v1/auth")
    @Headers({"accept: application/json","Content-Type: application/json"})
    Observable<Mahasiswa> getMahasiswa(@Body JsonObject body);


}
