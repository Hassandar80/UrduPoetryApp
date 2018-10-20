package com.hassandar.urdupoetry;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {


    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    String INTERSTITIAL_AD_UNIT = "ca-app-pub-2774902255682903/4291758523";

    Permission permission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permission.checkStorageWritPermission(this);
        MobileAds.initialize(this, "ca-app-pub-2774902255682903~4507063717");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("7D963530F19D8B0E85984E22F5A22C78").build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(INTERSTITIAL_AD_UNIT);
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("7D963530F19D8B0E85984E22F5A22C78").build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void btnUrduPoetry(View view) {
        Intent intent =new Intent(getApplicationContext(),PoetryActivity.class);
        startActivity(intent);



        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void rateThisApp(View view) {
        final String appPackageName = getApplicationContext().getPackageName();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));

    }

    public void moreApps(View view) {
       // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/dev?id=Hassan+Dar")));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://search?q=pub:Hassan Dar"));
        MainActivity.this.startActivity(intent);
    }

    public void shareWithFriends(View view) {
        final String appPackageName = getApplicationContext().getPackageName();
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Urdu Poetry Images");
            String sAux = "*200+ HD Urdu Poetry Images* \n\nLet me recommend you this application\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=" + appPackageName + "\n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }
}
