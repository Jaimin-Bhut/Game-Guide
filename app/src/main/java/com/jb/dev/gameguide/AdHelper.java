package com.jb.dev.gameguide;

import android.app.Activity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AdHelper {

    public static void prepareInterstitial(final InterstitialAd mInterstitialAd) {
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/8691691433");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });
    }

    public static void prepareBanner(AdView mAdView, Activity activity) {
        if (NetworkCheck.isConnect(activity)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.loadAd(new AdRequest.Builder().build());
        } else {
            mAdView.setVisibility(View.GONE);
        }
    }
}
