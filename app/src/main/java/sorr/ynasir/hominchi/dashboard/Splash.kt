package sorr.ynasir.hominchi.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpType
import sorr.ynasir.hominchi.R

class Splash : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val handler = Handler()

        splashAction(JumpType.JUMP_LINK,  3){ _, _ ->
            handler.postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },1500)
        }
    }
}

