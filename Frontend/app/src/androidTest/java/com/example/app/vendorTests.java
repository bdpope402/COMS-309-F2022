package com.example.app;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.StringContains.containsString;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class vendorTests {
    public static final int DELAY = 500;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

//    @Test
//    public void registerVendor() {
//        String username = "testingAdmin";
//        String password = "test";
//        String vendorName = "vendorTest";
//        String maintainer = "testingAdmin";
//        String booth = "99";
//
//        onView(withId(R.id.login)).perform(click());
//        onView(withId(R.id.username)).perform(typeText(username), closeSoftKeyboard());
//        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());
//        onView(withId(R.id.login)).perform(click());
//        onView(withText("ADMIN INFO")).perform(click());
//        onView(withId(R.id.change_vendor)).perform(click());
//        onView(withId(R.id.register)).perform(click());
//        onView(withId(R.id.vendor_name)).perform(typeText(vendorName), closeSoftKeyboard());
//        onView(withId(R.id.maintainer_username)).perform(typeText(maintainer), closeSoftKeyboard());
//        onView(withId(R.id.location)).perform(typeText(booth), closeSoftKeyboard());
//        onView(withId(R.id.register)).perform(click());
//        try {
//            Thread.sleep(DELAY);
//        } catch (InterruptedException e) {}
//        onView(withId(R.id.msgResponse)).check(matches(withText("You have successfully created a new vendor!")));
//        }

    @Test
    public void vendorLogin() {
        String username = "testingAdmin";
        String password = "test";
        String vendorName = "vendorTest";
        String maintainer = "testingAdmin";

        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.username)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("ADMIN INFO")).perform(click());
        onView(withId(R.id.change_vendor)).perform(click());
        onView(withId(R.id.vendor_name)).perform(typeText(vendorName), closeSoftKeyboard());
        onView(withId(R.id.maintainer_username)).perform(typeText(maintainer), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.msgResponse)).check(matches(withText("")));
    }

    @Test
    public void createMenu() {
        String username = "testingAdmin";
        String password = "test";
        String vendorName = "vendorTest";
        String maintainer = "testingAdmin";

        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.username)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("ADMIN INFO")).perform(click());
        onView(withId(R.id.change_vendor)).perform(click());
        onView(withId(R.id.vendor_name)).perform(typeText(vendorName), closeSoftKeyboard());
        onView(withId(R.id.maintainer_username)).perform(typeText(maintainer), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.create)).perform(click());
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {}
        onView(withId(R.id.msgResponse)).check(matches(withText(containsString("You"))));
    }

    @Test
    public void addFood() {
        String username = "testingAdmin";
        String password = "test";
        String vendorName = "vendorTest";
        String maintainer = "testingAdmin";
        String foodid = "50";
        String calories = "200";
        String name = "Icecream";
        String price = "4.99";
        String menuid = "226174239";

        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.username)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("ADMIN INFO")).perform(click());
        onView(withId(R.id.change_vendor)).perform(click());
        onView(withId(R.id.vendor_name)).perform(typeText(vendorName), closeSoftKeyboard());
        onView(withId(R.id.maintainer_username)).perform(typeText(maintainer), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.foodid)).perform(typeText(foodid), closeSoftKeyboard());
        onView(withId(R.id.calories)).perform(typeText(calories), closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText(name), closeSoftKeyboard());
        onView(withId(R.id.price)).perform(typeText(price), closeSoftKeyboard());
        onView(withId(R.id.menuid)).perform(typeText(menuid), closeSoftKeyboard());
        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.msgResponse)).check(matches(withText("You have successfully added a new food item!")));
    }

    @Test
    public void deleteFood() {
        String username = "testingAdmin";
        String password = "test";
        String vendorName = "vendorTest";
        String maintainer = "testingAdmin";
        String foodid = "50";
        String menuid = "226174239";

        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.username)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("ADMIN INFO")).perform(click());
        onView(withId(R.id.change_vendor)).perform(click());
        onView(withId(R.id.vendor_name)).perform(typeText(vendorName), closeSoftKeyboard());
        onView(withId(R.id.maintainer_username)).perform(typeText(maintainer), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.delete)).perform(click());
        onView(withId(R.id.foodid)).perform(typeText(foodid), closeSoftKeyboard());
        onView(withId(R.id.menuid)).perform(typeText(menuid), closeSoftKeyboard());
        onView(withId(R.id.delete)).perform(click());
        onView(withId(R.id.msgResponse)).check(matches(withText("You have successfully deleted a food item!")));
    }

}
