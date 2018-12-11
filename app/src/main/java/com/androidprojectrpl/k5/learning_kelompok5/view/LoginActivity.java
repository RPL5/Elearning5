package com.androidprojectrpl.k5.learning_kelompok5.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.androidprojectrpl.k5.learning_kelompok5.model.MahasiswaResponse;
import com.androidprojectrpl.k5.learning_kelompok5.network.ApiInterface;
import com.androidprojectrpl.k5.learning_kelompok5.network.ConsumeDataAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ApiInterface dataAPI;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataAPI = ConsumeDataAPI.getApiService();
        context = this;
        EditText edUsername = findViewById(R.id.edittext1);
        EditText edPassword = findViewById(R.id.edittext2);
        final String qUsername = edUsername.getText().toString();
        final String qPassword = edPassword.getText().toString();

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginRequest(qUsername, qPassword);
            }
        });
    }

    private void loginRequest(String username, String password){
        dataAPI.getMahasiswa(username,password)
                .enqueue(new Callback<MahasiswaResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<MahasiswaResponse> call, @NonNull Response<MahasiswaResponse> response) {
                        if (response.isSuccessful()){
                            Intent intent = new Intent(LoginActivity.this, NavDrawer.class);
                            assert response.body() != null;
                            List<Mahasiswa> data = response.body().getUser();
                            intent.putExtra("username", data.get(0).getNim());
                            intent.putExtra("nama",data.get(0).getNamaMhs());
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(context,"Gagal masuk..", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MahasiswaResponse> call, Throwable t) {
                        Log.e("login error","FAILURE : " + t.toString());
                        Toast.makeText(context,"Gagal masuk.. : " + t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
