package com.androidprojectrpl.k5.learning_kelompok5.network;

import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/v1/auth")
    Observable<Mahasiswa> getMahasiswa(@Field("username") String username,
                                       @Field("password") String password);


}
