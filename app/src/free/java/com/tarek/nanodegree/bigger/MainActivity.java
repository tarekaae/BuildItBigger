package com.tarek.nanodegree.bigger;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import ta.jokeviewermodule.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getResources().getString(R.string.ad_mob_app_id));
        AdView adView;
        adView = (AdView) findViewById(R.id.adView);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        adView.loadAd(adRequestBuilder.build());

    }

    public void start(View v) {

        final Intent intent = new Intent(MainActivity.this, JokeActivity.class);

        JokeTask jokeTask = new JokeTask() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                intent.putExtra("jokeContent", s);
                startActivity(intent);
            }
        };
        jokeTask.execute();


    }


}
