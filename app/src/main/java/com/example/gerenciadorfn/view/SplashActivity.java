package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.api.AppUtil;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        salvarSharedPreferences();



        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        },3000);
    }

    private void mostrarMainActivity() {
        Intent intent=new Intent(SplashActivity.this,
                LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.LOG_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

    }


}