package com.example.safuan.navbar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.victor.loading.rotate.RotateLoading;

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        RotateLoading rotateLoading = (RotateLoading) findViewById(R.id.rotateLoading);
        rotateLoading.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(a);
                finish();
            }
        }, 2000);
    }
}
