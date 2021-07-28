package com.example.electronicrosary.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.electronicrosary.Home.MainActivity;
import com.example.electronicrosary.Login.LoginActivity;
import com.example.electronicrosary.R;
import com.example.electronicrosary.UserSessions.UserData;

public class SplashActivity extends AppCompatActivity {
UserData userData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userData = new UserData(SplashActivity.this);
                if(userData.isLogin()){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }


            }
        },5000);




    }
}