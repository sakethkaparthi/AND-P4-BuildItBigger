package com.udacity.gradle.builditbigger.paid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import sakethkaparthi.androidjoker.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.OnFetchCompleted() {
            @Override
            public void onFetched(String result) {
                progressDialog.dismiss();
                startActivity(new Intent(MainActivity.this, JokeDisplayActivity.class).putExtra("joke", result));
            }
        });
        asyncTask.execute();
    }
}
