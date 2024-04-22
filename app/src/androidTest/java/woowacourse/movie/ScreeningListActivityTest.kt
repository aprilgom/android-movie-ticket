import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import woowacourse.movie.R
import woowacourse.movie.activity.ScreeningListActivity
import woowacourse.movie.model.screening.ScreeningDate
import woowacourse.movie.model.movieInfo.MovieInfo
import woowacourse.movie.model.movieInfo.RunningTime
import woowacourse.movie.model.movieInfo.Synopsis
import woowacourse.movie.model.movieInfo.Title
import woowacourse.movie.model.screening.Screening
import java.time.LocalDate

@RunWith(AndroidJUnit4::class)
@LargeTest
class ScreeningListActivityTest {
    private val movie =
        MovieInfo(
            Title("차람과 하디의 진지한 여행기"),
            RunningTime(230),
            Synopsis("wow!"),
        )

    @get:Rule
    val activityRule = ActivityScenarioRule(ScreeningListActivity::class.java)

    @Test
    fun listViewDisplaysMovieInfo() {
        onView(withId(R.id.movies_list_item)).check(matches(isDisplayed()))

        onData(anything())
            .inAdapterView(withId(R.id.movies_list_item))
            .atPosition(0)
            .onChildView(withId(R.id.movie_title))
            .check(matches(withText(movie.title.toString())))
    }

    @Test
    fun clickButtonInListViewItem_opensNewActivity() {
        onData(anything())
            .inAdapterView(withId(R.id.movies_list_item))
            .atPosition(0)
            .onChildView(withId(R.id.movie_details_button))
            .perform(click())

        onView(withId(R.id.scroll_view))
            .check(matches(isDisplayed()))
    }
}
