package sakethkaparthi.androidjoker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
        String joke = getIntent().getStringExtra("joke");
        jokeTextView.setText(joke);
    }
}
