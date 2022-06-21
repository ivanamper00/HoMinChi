package sorr.ynasir.hominchi.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import sorr.ynasir.hominchi.R

class MainActivity : AppCompatActivity() {

    private var bckToExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onBackPressed() {
        if (bckToExit){
            super.finishAffinity()
            return
        }
        this.bckToExit = true
        Toast.makeText(this,"Press again to exit",Toast.LENGTH_SHORT).show()
        Handler().postDelayed({bckToExit = false},2000)
    }
}