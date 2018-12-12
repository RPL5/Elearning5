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
    EditText edUsername,edPassword;
    String qUsername, qPassword;

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

    public void login(View view){
        edUsername = findViewById(R.id.edittext1);
        edPassword = findViewById(R.id.edittext2);
        qUsername = edUsername.getText().toString();
        qPassword = edPassword.getText().toString();

        Log.e("USER AND PASSWORD VALUE",qUsername + " " + qPassword);
        loginRequest(qUsername, qPassword);
    }

    private void loginRequest(String username, String password){
        dataAPI.getMahasiswa(username,password)
                .enqueue(new Callback<MahasiswaResponse>() {
                    @Override
                    public void onResponse(Call<MahasiswaResponse> call, Response<MahasiswaResponse> response) {
                        Log.i("RESPONSE INFO",response.message() + " and " + response.isSuccessful() );
                        if (response.isSuccessful()){
                            assert response.body() != null;
                            List<Mahasiswa> data = response.body().getUser();
                            Intent intent = new Intent(LoginActivity.this, NavDrawer.class);
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
