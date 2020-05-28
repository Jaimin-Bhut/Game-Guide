package com.jb.dev.gameguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonNo, buttonYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        buttonNo = findViewById(R.id.btn_no);
        buttonYes = findViewById(R.id.btn_yes);
        buttonYes.setOnClickListener(this);
        buttonNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.btn_no:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.btn_yes:
                finish();
                break;
        }
    }
}
