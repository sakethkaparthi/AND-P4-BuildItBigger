package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.saketh.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by saketh on 14/8/16.
 */
public class AsyncTest extends AsyncTask<Void, Void, String> {
    private OnJokeFetchedListener listener;
    private MyApi myApiService = null;
    private Context context;

    public AsyncTest(Context context, OnJokeFetchedListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(context.getResources().getString(R.string.root_url));
            // end options for devappserver

            myApiService = builder.build();
        }
        try {
            return myApiService.fetchJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.onJokeFetched(result);
    }

    public interface OnJokeFetchedListener {
        void onJokeFetched(String joke);
    }
}

