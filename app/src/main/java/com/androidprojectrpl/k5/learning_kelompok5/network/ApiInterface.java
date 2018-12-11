package com.androidprojectrpl.k5.learning_kelompok5.network;

import com.androidprojectrpl.k5.learning_kelompok5.model.MahasiswaResponse;
import com.androidprojectrpl.k5.learning_kelompok5.model.MatkulModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("auth/login")
    Call<MahasiswaResponse> getMahasiswa(@Field("nim") String nim,
                                         @Field("password") String password);

    @GET("api/makul")
    Call<MatkulModel> getMatkul();
}
