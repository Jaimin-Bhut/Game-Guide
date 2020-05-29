package com.jb.dev.gameguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class SplashActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        view = findViewById(android.R.id.content);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (NetworkCheck.isConnect(SplashActivity.this)) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    Snackbar.make(view, "Start Network", BaseTransientBottomBar.LENGTH_SHORT).setAction("Turn On", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent((Settings.ACTION_NETWORK_OPERATOR_SETTINGS)));
                        }
                    }).show();
                }
            }
        }, 1000);

    }

}
