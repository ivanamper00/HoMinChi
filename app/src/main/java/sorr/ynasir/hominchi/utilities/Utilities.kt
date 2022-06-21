package sorr.ynasir.hominchi.utilities

import android.os.Handler
import androidx.viewpager2.widget.ViewPager2
import sorr.ynasir.hominchi.R
import java.util.*

class Utilities {

    companion object {

        var dataImg = arrayListOf(R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3)

    fun setTimer(viewPager2: ViewPager2, totalPages: Int){
        var currentPage = 0
            val DELAY_MS: Long = 500
            val PERIOD_MS: Long = 3000

        val handler = Handler()
        val update = Runnable {
            if (currentPage == totalPages) currentPage = 0
            viewPager2.setCurrentItem(currentPage++, true)
        }
        val timer = Timer() // This will create a new Thread
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
                }
            }, DELAY_MS,PERIOD_MS)
        }
    }
}