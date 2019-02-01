package com.tarek.nanodegree.bigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.tarek.nanodegree.jokes.backend.myApi.MyApi;

import java.io.IOException;


/**
 * Created by tarek.abdulkader on 2/14/2018.
 */

public class JokeTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {

//        String url = "http://localhost:8080/_ah/api/myApi/v1/sayHi/";

        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setApplicationName("backend")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        MyApi myApiService = builder.build();

        String joke = null;

        try {
            joke = myApiService.getAjoke().execute().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joke;
    }

}