package com.androidprojectrpl.k5.learning_kelompok5.view.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.androidprojectrpl.k5.learning_kelompok5.view.main.NavDrawer;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private ProgressDialog pdDialog;
    EditText edUsername,edPassword;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);

        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginRequest(edUsername.getText().toString(),edPassword.getText().toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void setAction(@NonNull Mahasiswa data) {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedLearning",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",data.getUsername());
        editor.putString("id",data.getId_user());
        editor.putBoolean("isLogin",true);
        editor.apply();
        editor.commit();

        Intent intent = new Intent(this, NavDrawer.class);
        startActivity(intent);
    }

    @Override
    public void onFailRequest(@NonNull String errMessage) {
        setMessage(errMessage);
    }

    private void setMessage(String err){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(err);
        alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public void showProgress() {
        pdDialog = ProgressDialog.show(this,"","Tunggu sebentar");
        pdDialog.setCancelable(false);
    }

    @Override
    public void hideProgress() {
        pdDialog.dismiss();
    }
}