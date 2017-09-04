package io.shtanko.android_viper;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class) public class MainActivityInstrumentedTest {

  @Test public void useAppContext() throws Exception {

    Context appContext = InstrumentationRegistry.getTargetContext();

    onView(withId(R.id.textHello)).perform(click()).check(matches(isDisplayed()));

    assertEquals("io.shtanko.android_viper", appContext.getPackageName());
  }
}
