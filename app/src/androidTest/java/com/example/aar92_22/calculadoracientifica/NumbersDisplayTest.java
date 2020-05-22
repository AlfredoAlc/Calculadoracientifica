package com.example.aar92_22.calculadoracientifica;



import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(JUnit4.class)
public class NumbersDisplayTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testAllNumbers(){
        onView(withId(R.id.n1)).perform(click());
        onView(withId(R.id.n2)).perform(click());
        onView(withId(R.id.n3)).perform(click());
        onView(withId(R.id.n4)).perform(click());
        onView(withId(R.id.n5)).perform(click());
        onView(withId(R.id.n6)).perform(click());
        onView(withId(R.id.n7)).perform(click());
        onView(withId(R.id.n8)).perform(click());
        onView(withId(R.id.n9)).perform(click());

        onView(withId(R.id.numberDisplay)).check(matches(withText("123,456,789")));
    }

    @Test
    public void testDecimalNumbers(){
        onView(withId(R.id.n6)).perform(click());
        onView(withId(R.id.n4)).perform(click());
        onView(withId(R.id.n8)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.n6)).perform(click());
        onView(withId(R.id.n1)).perform(click());
        onView(withId(R.id.n2)).perform(click());
        onView(withId(R.id.n9)).perform(click());

        onView(withId(R.id.numberDisplay)).check(matches(withText("648.6129")));

    }




}
