package com.udacity.gradle.builditbigger;

import android.content.ComponentName;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import com.udacity.gradle.builditbigger.joker.JokeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class GetJokeTaskTest {

    @Rule public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() throws Exception {
        Intents.init();
    }

    @Test
    public void correctlyGetsJoke() {
        onView(withId(R.id.tell_joke)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), JokeActivity.class)));
    }
}
