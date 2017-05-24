package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.buttink.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class GetJokeTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService;
    private final Object apiLock = new Object();

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            synchronized (apiLock) {
                if (myApiService == null) {
                    initializeApiService();
                }
            }
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return "FAILURE";
        }
    }

    private void initializeApiService() {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                                                  new AndroidJsonFactory(), null)
                // options for running against local devappserver
                // - 10.0.2.2 is localhost's IP address in Android emulator
                // - turn off compression when running against local devappserver
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        // end options for devappserver

        myApiService = builder.build();
    }
}
