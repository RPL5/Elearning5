package com.androidprojectrpl.k5.learning_kelompok5.view.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.network.ApiInterface;
import com.androidprojectrpl.k5.learning_kelompok5.network.ConsumeDataAPI;
import com.androidprojectrpl.k5.learning_kelompok5.view.main.NavDrawer;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private ApiInterface dataAPI;
    private Context context;
    private ProgressDialog pdDialog;
    EditText edUsername,edPassword;
    String qUsername, qPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.password);
        String qUsername = edUsername.getText().toString();
        String qPassword = edPassword.getText().toString();

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void setAction() {
        Intent intent = new Intent(this.context, NavDrawer.class);
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
    }
}