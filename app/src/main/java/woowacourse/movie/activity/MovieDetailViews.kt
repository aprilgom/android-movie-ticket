package woowacourse.movie.activity

import android.widget.TextView
import woowacourse.movie.uiModels.movie.MovieDetail

class MovieDetailViews(
    private val title: TextView,
    private val screeningPeriod: TextView,
    private val runningTime: TextView,
    private val synopsis: TextView,
) {
    fun set(movieDetail: MovieDetail) {
        title.text = movieDetail.title
        screeningPeriod.text = movieDetail.screeningPeriod
        runningTime.text = movieDetail.runningTime
        synopsis.text = movieDetail.synopsis
    }
}
