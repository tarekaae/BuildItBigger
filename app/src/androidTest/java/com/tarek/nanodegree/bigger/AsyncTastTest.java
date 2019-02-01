package com.tarek.nanodegree.bigger;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import ta.jokeviewermodule.JokeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;

/**
 * Created by z on 2/15/2018.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTastTest extends AndroidTestCase {

    @Rule
    public ActivityTestRule<JokeActivity> activityTestRule  = new ActivityTestRule<JokeActivity>(JokeActivity.class);

    @Test
    public void verifyLoadingData() {
        try {

            JokeTask task = new JokeTask();
            task.execute();
            String joke = task.get(30, TimeUnit.SECONDS);

            assertNotNull(joke);
            assertTrue(joke.length() > 0);

            onView(withId(R.id.tv_joke)).check(matches(isDisplayed()));

        } catch (Exception e) {
            fail("Operation timed out");

        }


    }
}
