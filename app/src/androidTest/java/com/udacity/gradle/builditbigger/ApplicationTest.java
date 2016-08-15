package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void testJoker() throws Exception {
        new AsyncTest(new AsyncTest.OnJokeFetchedListener() {
            @Override
            public void onJokeFetched(String joke) {
                assertNotNull(joke);
                assertTrue(joke.length() > 0);
            }
        }).execute();
    }
}