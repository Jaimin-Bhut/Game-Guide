package com.jb.dev.gameguide;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MainActivity";
    Button buttonWin, buttonShare, buttonRate;
    InterstitialAd mInterstitialAd;
    AdView mAdBanner, mAdBannerTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRate = findViewById(R.id.btn_rate);
        buttonShare = findViewById(R.id.btn_share);
        buttonWin = findViewById(R.id.btn_win);
        mAdBannerTop = findViewById(R.id.mainBannerTop);
        mAdBanner = findViewById(R.id.mainBanner);
        buttonWin.setOnClickListener(this);
        buttonRate.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        mInterstitialAd = new InterstitialAd(this);
        AdHelper.prepareInterstitial(mInterstitialAd);
        AdHelper.prepareBanner(mAdBanner, this);
        AdHelper.prepareBanner(mAdBannerTop, this);

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.btn_share:
                isLoad();
                break;
            case R.id.btn_rate:
                rateAction();
                break;
            case R.id.btn_win:
                startActivity(new Intent(this, GuideActivity.class));
                break;
        }
    }

    private void isLoad() {
        boolean installed = CheckInstall.appInstallCheck("com.whatsapp", this);
        String c = String.valueOf(Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()));
        if (installed) {
            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.setPackage("com.whatsapp");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, c);
            startActivity(whatsappIntent);
        } else {
            Toast.makeText(this, "WhatsApp Not Install", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, ExitActivity.class));
        finish();
    }

    public void rateAction() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }
}
