import android.os.AsyncTask;

import com.example.saketh.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by saketh on 14/8/16.
 */
public class AsyncTest {
    @Test
    public void nonEmptyResponseTest() {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.execute();
    }

    class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
        private MyApi myApiService = null;

        @Override
        protected String doInBackground(Void... params) {
            if (myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://build-it-bigger-140314.appspot.com/_ah/api/");
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
            assert result.length() > 0;
        }
    }
}
