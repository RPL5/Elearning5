package com.androidprojectrpl.k5.learning_kelompok5.network;

import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.androidprojectrpl.k5.learning_kelompok5.model.User;
import com.google.gson.JsonObject;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInterface {

    @POST("api/v1/auth")
    @Headers({"accept: application/json","Content-Type: application/json"})
    Observable<Mahasiswa> getMahasiswa(@Body JsonObject body);

    @GET("api/v1/user/{id_user}")
    @Headers("accept: application/json")
    Observable<User> getUser(@Path("id_user") int id_user);
}
