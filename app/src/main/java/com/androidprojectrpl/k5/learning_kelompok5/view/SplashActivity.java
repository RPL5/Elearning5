package com.androidprojectrpl.k5.learning_kelompok5.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidprojectrpl.k5.learning_kelompok5.view.login.LoginActivity;
import com.androidprojectrpl.k5.learning_kelompok5.view.main.NavDrawer;

public class SplashActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("SharedLearning",MODE_PRIVATE);

        if (prefs.getBoolean("isLogin",false)){
            intent = new Intent(this, NavDrawer.class);
        }
        else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
