package com.jb.dev.gameguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class GuideActivity extends AppCompatActivity {
    Button buttonGuide;
    InterstitialAd interstitialAd;
    AdView adViewTop;
    AdView adViewBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        adViewBottom = findViewById(R.id.GuideBanner);
        adViewTop = findViewById(R.id.GuideBannerTop);
        interstitialAd = new InterstitialAd(this);
        buttonGuide = findViewById(R.id.btn_guide);
        AdHelper.prepareInterstitial(interstitialAd);
        buttonGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, GuideListActivity.class));
            }
        });

        AdHelper.prepareBanner(adViewBottom, this);
        AdHelper.prepareBanner(adViewTop, this);
    }
}
