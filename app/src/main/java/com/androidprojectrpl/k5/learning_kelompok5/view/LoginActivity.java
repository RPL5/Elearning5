package com.androidprojectrpl.k5.learning_kelompok5.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.androidprojectrpl.k5.learning_kelompok5.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void LOGIN(View view) {
        EditText edUsername=findViewById(R.id.edittext1);
        EditText edPassword=findViewById(R.id.edittext2);
        String qUsername = edUsername.getText().toString();
        String qPassword = edPassword.getText().toString();
        if(qUsername.trim().equals("")) {
            edUsername.setError("Silahkan mengisi username terlebih dahulu");
            return;
        }
        if(qPassword.trim().equals("")) {
            edPassword.setError("Silahkan mengisi Password terlebih dahulu");
            return;
        }
        Intent intent = new Intent(LoginActivity.this, NavDrawer.class);
        startActivity(intent);
    }
}
