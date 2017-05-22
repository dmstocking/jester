package com.udacity.gradle.builditbigger.joker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static Intent getIntent(@NonNull Context context, @NonNull String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke", joke);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView textView = (TextView) findViewById(R.id.joke);
        Intent intent = getIntent();
        if (intent.hasExtra("joke")) {
            textView.setText(intent.getStringExtra("joke"));
        }
    }
}
