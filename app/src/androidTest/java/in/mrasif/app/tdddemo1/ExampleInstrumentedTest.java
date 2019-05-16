package in.mrasif.app.tdddemo1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rules=new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("in.mrasif.app.tdddemo1", appContext.getPackageName());
    }

    @Test
    public void user_can_enter_first_name(){
        onView(withId(R.id.firstName)).perform(typeText("Asif"));
    }

    @Test
    public void user_can_enter_last_name(){
        onView(withId(R.id.lastName)).perform(typeText("Mollah"));
    }

    @Test
    public void when_user_enter_first_and_last_name_check_to_confirm_that_message_is_correct(){
        onView(withId(R.id.firstName)).perform(typeText("Asif"));
        onView(withId(R.id.lastName)).perform(typeText("Mollah"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Welcome, Asif Mollah!")));
    }

    @Test
    public void message_test_again(){
        onView(withId(R.id.firstName)).perform(typeText("Asif"));
        onView(withId(R.id.lastName)).perform(typeText("Mollah"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Welcome, Asif Mollah!")));
    }
}
