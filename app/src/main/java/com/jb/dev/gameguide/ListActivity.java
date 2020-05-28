package com.jb.dev.gameguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ListActivity extends AppCompatActivity {
    TextView textViewDetails;
    AdView adViewMiddle, adViewBottom;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        interstitialAd = new InterstitialAd(this);
        adViewBottom = findViewById(R.id.listBannerBottom);
        adViewMiddle = findViewById(R.id.listBannerMiddle);
        AdHelper.prepareBanner(adViewBottom, this);
        AdHelper.prepareBanner(adViewMiddle, this);
        textViewDetails = findViewById(R.id.txt_details);
        Intent intent = getIntent();
        int i = intent.getIntExtra("details", 0);
        switch (i) {
            case 1:
                textViewDetails.setText(R.string.d1);
                break;
            case 2:
                textViewDetails.setText(R.string.d2);
                break;
            case 3:
                textViewDetails.setText(R.string.d3);
                break;
            case 4:
                textViewDetails.setText(R.string.d4);
                break;
            case 5:
                textViewDetails.setText(R.string.d5);
                break;
            case 6:
                textViewDetails.setText(R.string.d6);
                break;
            case 7:
                textViewDetails.setText(R.string.d7);
                break;
        }
    }
}
