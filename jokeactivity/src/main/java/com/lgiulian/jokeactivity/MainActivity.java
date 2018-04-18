package com.lgiulian.jokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle extras = getIntent().getExtras();
        String joke = null;
        if (extras != null && extras.containsKey(JOKE_KEY)) {
            joke = extras.getString(JOKE_KEY, "");
        }
        Log.d(TAG, joke);
        Toast.makeText(this, joke + "**********", Toast.LENGTH_SHORT).show();
    }

}
