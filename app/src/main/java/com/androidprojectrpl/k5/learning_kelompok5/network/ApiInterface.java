package com.androidprojectrpl.k5.learning_kelompok5.network;

import com.androidprojectrpl.k5.learning_kelompok5.model.ClassInfo;
import com.androidprojectrpl.k5.learning_kelompok5.model.ClassUser;
import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.androidprojectrpl.k5.learning_kelompok5.model.Result;
import com.androidprojectrpl.k5.learning_kelompok5.model.User;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInterface {

    //AUTH
    @POST("api/v1/signup")
    @Headers({"accept: application/json\",\"Content-Type: application/json"})
    Observable<Result> register(@Body JsonObject body);

    @POST("api/v1/auth")
    @Headers({"accept: application/json","Content-Type: application/json"})
    Observable<Mahasiswa> getMahasiswa(@Body JsonObject body);

    //User
    @GET("api/v1/user/{id_user}")
    @Headers("accept: application/json")
    Observable<User> getUser(@Path("id_user") int id_user);


    @POST("api/v1/update/{id_user}")
    @Headers({"accept: application/json\",\"Content-Type: application/json"})
    Observable<Result> updateProfile(@Path("id_user") int id, @Body JsonObject body);

    //Class
    @POST("api/v1/create_class")
    @Headers({"accept: application/json\",\"Content-Type: application/json"})
    Observable<Result> createClass(@Body JsonObject body);

    @GET("api/v1/getclass/{id_class}")
    @Headers({"accept: application/json"})
    Observable<List<ClassInfo>> getClassPosting (@Path("id_class") int id);

    @GET("api/v1/class/{id_user}")
    @Headers({"accept: application/json"})
    Observable<List<ClassUser>> getClassById (@Path("id_user") int id);


}
