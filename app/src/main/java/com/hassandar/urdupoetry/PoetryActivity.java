package com.hassandar.urdupoetry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class PoetryActivity extends AppCompatActivity {

    public Integer[] images = {
            R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10
            ,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20,R.drawable.p21
            ,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,R.drawable.p30,R.drawable.p31,R.drawable.p32
            ,R.drawable.p33,R.drawable.p34,R.drawable.p35,R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,R.drawable.p40,R.drawable.p41,R.drawable.p42
            ,R.drawable.p43,R.drawable.p44,R.drawable.p45,R.drawable.p46,R.drawable.p47,R.drawable.p48,R.drawable.p49,R.drawable.p50,R.drawable.p51,R.drawable.p52
            ,R.drawable.p53,R.drawable.p54,R.drawable.p55,R.drawable.p56,R.drawable.p57,R.drawable.p58,R.drawable.p59,R.drawable.p60,R.drawable.p61,R.drawable.p62
            ,R.drawable.p63,R.drawable.p64,R.drawable.p65,R.drawable.p66,R.drawable.p67,R.drawable.p68,R.drawable.p69,R.drawable.p70,R.drawable.p71,R.drawable.p72
            ,R.drawable.p73,R.drawable.p74,R.drawable.p75,R.drawable.p76,R.drawable.p77,R.drawable.p78,R.drawable.p79,R.drawable.p80,R.drawable.p81,R.drawable.p82
            ,R.drawable.p83,R.drawable.p84,R.drawable.p85,R.drawable.p86,R.drawable.p87,R.drawable.p88,R.drawable.p89,R.drawable.p90,R.drawable.p91,R.drawable.p92
            ,R.drawable.p93,R.drawable.p94,R.drawable.p95,R.drawable.p96,R.drawable.p97,R.drawable.p98,R.drawable.p99,R.drawable.p100,R.drawable.p101,R.drawable.p102
            ,R.drawable.p103,R.drawable.p104,R.drawable.p105,R.drawable.p106,R.drawable.p107,R.drawable.p108,R.drawable.p109,R.drawable.p110,R.drawable.p111,R.drawable.p112
            ,R.drawable.p113,R.drawable.p114,R.drawable.p115,R.drawable.p116,R.drawable.p117,R.drawable.p118,R.drawable.p119,R.drawable.p120,R.drawable.p121,R.drawable.p122
            ,R.drawable.p123,R.drawable.p124,R.drawable.p125,R.drawable.p126,R.drawable.p127,R.drawable.p128,R.drawable.p129,R.drawable.p130,R.drawable.p131,R.drawable.p132
            ,R.drawable.p133,R.drawable.p134,R.drawable.p135,R.drawable.p136,R.drawable.p137,R.drawable.p138,R.drawable.p139,R.drawable.p140,R.drawable.p141,R.drawable.p142
            ,R.drawable.p143,R.drawable.p144,R.drawable.p145,R.drawable.p146,R.drawable.p147,R.drawable.p148,R.drawable.p149,R.drawable.p150,R.drawable.p151,R.drawable.p152
            ,R.drawable.p153,R.drawable.p154,R.drawable.p155,R.drawable.p156,R.drawable.p157,R.drawable.p158,R.drawable.p159,R.drawable.p160,R.drawable.p161,R.drawable.p162
            ,R.drawable.p163,R.drawable.p164,R.drawable.p165,R.drawable.p166,R.drawable.p167,R.drawable.p168,R.drawable.p169,R.drawable.p170,R.drawable.p171,R.drawable.p172
            ,R.drawable.p173,R.drawable.p174,R.drawable.p175,R.drawable.p176,R.drawable.p177,R.drawable.p178,R.drawable.p179,R.drawable.p180,R.drawable.p181,R.drawable.p182
            ,R.drawable.p183,R.drawable.p184,R.drawable.p185
    };
    int adCount = 0;
    ImageView imageview;
    int count=0;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    String INTERSTITIAL_AD_UNIT = "ca-app-pub-2774902255682903/4291758523";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poetry);


        imageview = findViewById(R.id.imageView);
        imageview.setImageResource(images[count]);

        //============== Code for Circle Image Shape ========================

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imageIcon);
//        RoundedBitmapDrawable mDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
//        mDrawable.setCircular(true);
//        imageview.setImageDrawable(mDrawable);

        //============== Code for Circle Image Shape ========================


        // ============================ Zoom ImageView With Dialog Box =====================================
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PoetryActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                PhotoView photoView = mView.findViewById(R.id.imageView);
                photoView.setImageResource(images[count]);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
        // ============================ Zoom ImageView With Dialog Box =====================================



//  =================================== Start Ads Code Here ===============================
        MobileAds.initialize(this, "ca-app-pub-2774902255682903~4507063717");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("7D963530F19D8B0E85984E22F5A22C78").build();
        mAdView.loadAd(adRequest);

        loadAd();
//  =================================== Start Ads Code Here ===============================

}



    private void loadAd() {

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

    public void saveImage(View view) {

        BitmapDrawable draw = (BitmapDrawable) imageview.getDrawable();
        Bitmap bitmap = draw.getBitmap();

        FileOutputStream outStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/Urdu Poetry");
        dir.mkdirs();
        String fileName = String.format("%d.jpg", System.currentTimeMillis());
        File outFile = new File(dir, fileName);
        try {
            outStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
        try {
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"Image Saved to Gallery", Toast.LENGTH_LONG).show();

        refreshGallery(outFile);

    }

    private void refreshGallery(File file){
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

    public void nextImage(View view) {
        if(adCount==11){
            adCount=2;
        }
        else{
            adCount++;
        }
        if(count<184){
            count++;
        }
        else{
            count=0;
        }
        logic();

    }

    public void backImage(View view) {
        if(adCount==11){
            adCount=2;
        }
        else{
            adCount++;
        }
        if(count>0){
            count--;
        }
        else{
            count=184;
        }
        logic();
    }

    public void logic(){
        imageview.setImageResource(images[count]);


        if(adCount==10){
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }


    }

    public void shareImage(View view){

        Bitmap bitmap =getBitmapFromView(imageview);
        try {
            File file = new File(this.getExternalCacheDir(),"urdupoetry.png");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/png");
            startActivity(Intent.createChooser(intent, "Share image via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }   else{
            //does not have background drawable, then draw white background on the canvas
            //canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }
}
