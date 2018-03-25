package com.mytaxi.android_demo;

import android.os.SystemClock;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mytaxi.android_demo.activities.MainActivity;

/**
 * Created by AL on 23/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class MyTaxiTest {


    @Rule
    public final ActivityRule<MainActivity> mainActivity = new ActivityRule<>(MainActivity.class);


    @Test
    public void login_valid_Test() {

        // Assign variables from a Test Data object file
        String password = TestData.User.VALID_PASSWORD;
        String userName = TestData.User.VALID_USERNAME;
        String searchQuery = TestData.Search.VALID_SEARCH_QUERY;
        String searchNameToSelect = TestData.Search.VALID_SEARCH_NAME_TO_SELECT;

        // Assert username/password fields and login button are displayed
        onView(withId(R.id.edt_password)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.edt_username)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.btn_login)).check(ViewAssertions.matches(isDisplayed()));

        // Enter username and password
        onView(withId(R.id.edt_username)).perform(replaceText(userName));
        onView(withId(R.id.edt_password)).perform(replaceText(password));

        // Click on login button
        onView(withId(R.id.btn_login)).perform(click());

        SystemClock.sleep(1000);

        // Assert search box is displayed and enter the search query
        onView(withId(R.id.textSearch)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.textSearch)).perform(replaceText(searchQuery));

        SystemClock.sleep(1000);

        // Click on the specific name on the auto complete
        onView(withText(searchNameToSelect)).inRoot(RootMatchers.withDecorView(not(is(mainActivity.get().getWindow().getDecorView())))).perform(click());

        // Click on the telephone button
        onView(withId(R.id.fab)).perform(click());
    }
}


