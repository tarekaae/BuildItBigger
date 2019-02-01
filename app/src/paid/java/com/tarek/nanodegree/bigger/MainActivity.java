package com.tarek.nanodegree.bigger;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ta.jokeviewermodule.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paid);


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
