package com.jb.dev.gameguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class GuideListActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7;
    AdView adView, adViewTop;
    InterstitialAd interstitialAd;
    int i = 0;
    boolean value = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_list);

        interstitialAd = new InterstitialAd(this);
        adView = findViewById(R.id.GuideListBanner);
        adViewTop = findViewById(R.id.GuideListBannerTop);
        cardView1 = findViewById(R.id.btn1);
        cardView2 = findViewById(R.id.btn2);
        cardView3 = findViewById(R.id.btn3);
        cardView4 = findViewById(R.id.btn4);
        cardView5 = findViewById(R.id.btn5);
        cardView6 = findViewById(R.id.btn6);
        cardView7 = findViewById(R.id.btn7);
        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
        cardView6.setOnClickListener(this);
        cardView7.setOnClickListener(this);
        AdHelper.prepareBanner(adView, this);
        AdHelper.prepareBanner(adViewTop, this);
        AdHelper.prepareInterstitial(interstitialAd);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        Intent intent = new Intent(this, ListActivity.class);
        switch (i) {
            case R.id.btn1:
                isLoadAd();
                intent.putExtra("details", 1);
                startActivity(intent);
                break;
            case R.id.btn2:
                isLoadAd();
                intent.putExtra("details", 2);
                startActivity(intent);
                break;
            case R.id.btn3:
                isLoadAd();
                intent.putExtra("details", 3);
                startActivity(intent);
                isLoadAd();
                break;
            case R.id.btn4:
                isLoadAd();
                intent.putExtra("details", 4);
                startActivity(intent);
                break;
            case R.id.btn5:
                isLoadAd();
                intent.putExtra("details", 5);
                startActivity(intent);
                break;
            case R.id.btn6:
                isLoadAd();
                intent.putExtra("details", 6);
                startActivity(intent);
                break;
            case R.id.btn7:
                isLoadAd();
                intent.putExtra("details", 7);
                startActivity(intent);
                break;
        }
    }

    void isLoadAd() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("Ad", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", i);
        int j = sharedPreferences.getInt("count", 0);
        if (j == 2) {
            AdHelper.prepareInterstitial(interstitialAd);
            editor.putInt("count", 0);
        } else {
            editor.putInt("count", j + 1);
        }
    }
}
