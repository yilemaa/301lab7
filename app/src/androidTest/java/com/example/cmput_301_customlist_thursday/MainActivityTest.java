package com.example.cmput_301_customlist_thursday;

import static org.junit.Assert.*;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);


    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), rule.getActivity());
    }

    @Test
    public void start() throws Exception {
        Activity activity = rule.getActivity();
    }

    @Test
    public void checkList() {
// Asserts that the current activity is the MainActivity. Otherwise, show “Wrong Activity”
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
//Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button
        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText
/* True if there is a text: Edmonton on the screen, wait at least 2 seconds and find
minimum one match. */
        assertTrue(solo.waitForText("Edmonton", 1, 2000));
        solo.clickOnButton("ClEAR ALL"); //Select ClEAR ALL
//True if there is no text: Edmonton on the screen
        assertFalse(solo.searchText("Edmonton"));
    }

    @Test
    public void checkCiyListItem(){
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY");
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM");
        solo.waitForText("Edmonton", 1, 2000);
// Get MainActivity to access its variables and methods.
        MainActivity activity = (MainActivity) solo.getCurrentActivity();
        final ListView cityList = activity.cityList; // Get the listview
        String city = (String) cityList.getItemAtPosition(0); // Get item from first position
        assertEquals("Edmonton", city);
    }

    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}