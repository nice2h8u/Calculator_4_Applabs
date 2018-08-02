package nicetoh8u.calculator_4_applabs;





import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkDots() {
        onView(withId(R.id.button_0))
                .perform(click());
        onView(withId(R.id.button_0))
                .perform(click());
        onView(withId(R.id.button_0))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button3))
                .perform(click());
        onView(withId(R.id.button_plus))
                .perform(click());
        onView(withId(R.id.button3))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());
        onView(withId(R.id.calculate_area))
                .check(matches(withText("3.30")));

    }

    @Test
    public void checkPlusOperation() {
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_plus))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());
        onView(withId(R.id.calculate_area))
                .check(matches(withText("2.10")));

    }

    @Test
    public void checkMinusOperation() {
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_minus))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());
        onView(withId(R.id.calculate_area))
                .check(matches(withText("0.10")));

    }

    @Test
    public void checkMultiOperation() {
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_multi))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());
        onView(withId(R.id.calculate_area))
                .check(matches(withText("1.10")));

    }
    @Test
    public void checkDivOperation() {
        onView(withId(R.id.button8))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button8))
                .perform(click());
        onView(withId(R.id.button_div))
                .perform(click());
        onView(withId(R.id.button4))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());
        onView(withId(R.id.calculate_area))
                .check(matches(withText("2.20")));

    }

    @Test
    public void checkClickOnNumbers() {


        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button2))
                .perform(click());
        onView(withId(R.id.button3))
                .perform(click());
        onView(withId(R.id.button4))
                .perform(click());
        onView(withId(R.id.button5))
                .perform(click());
        onView(withId(R.id.button_plus))
                .perform(click());
        onView(withId(R.id.button6))
                .perform(click());
        onView(withId(R.id.button7))
                .perform(click());
        onView(withId(R.id.button8))
                .perform(click());
        onView(withId(R.id.button9))
                .perform(click());
        onView(withId(R.id.button_0))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());

       // check that TextView contains error text
        onView(withId(R.id.calculate_area))
                .check(matches(withText("80235")));
    }

    @Test
    public void tryToFindErrors(){
        onView(withId(R.id.button_minus))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button8))
                .perform(click());
        onView(withId(R.id.button_delete))
                .perform(click()).perform(click()).perform(click());
        onView(withId(R.id.button8))
                .perform(click());
        onView(withId(R.id.button_div))
                .perform(click());
        onView(withId(R.id.button_multi))
                .perform(click());
        onView(withId(R.id.button9))
                .perform(click());
        onView(withId(R.id.button_dot))
                .perform(click());
        onView(withId(R.id.button_result))
                .perform(click());
        onView(withId(R.id.button_minus))
                .perform(click());
        onView(withId(R.id.button_plus))
                .perform(click());
        onView(withId(R.id.button_div))
                .perform(click());
        onView(withId(R.id.button_multi))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_div))
                .perform(click());

        // check that TextView contains error text
        onView(withId(R.id.calculate_area))
                .check(matches(withText("72.80/")));
    }

    @Test
    public void checkCancelButton(){

        onView(withId(R.id.button_plus))
                .perform(click());
        onView(withId(R.id.button_minus))
                .perform(click());
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.button_multi))
                .perform(click());
        onView(withId(R.id.button_0))
                .perform(click());
        onView(withId(R.id.button_div))
                .perform(click());
        onView(withId(R.id.button_cancel))
                .perform(click());

        // check that TextView contains error text
        onView(withId(R.id.calculate_area))
                .check(matches(withText("")));
    }

}
