package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.joker.JokeActivity;
import com.udacity.gradle.builditbigger.jokes.Jokes;
import com.udacity.gradle.builditbigger.jokes.RandomUtils;


public class MainActivity extends AppCompatActivity {

    @NonNull private final Jokes jokes = new Jokes(new RandomUtils());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new GetJokeTask() {
            @Override
            protected void onPostExecute(String joke) {
                super.onPostExecute(joke);
                if (!"FAILURE".equals(joke)) {
                    startActivity(JokeActivity.getIntent(MainActivity.this, joke));
                }
            }
        }.execute();
    }
}
