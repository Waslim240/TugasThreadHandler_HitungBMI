package waslim.binar.andlima.latihan_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import waslim.binar.andlima.latihan_bmi.thread.Thread
import waslim.binar.andlima.latihan_bmi.threadhandler.ThreadHandler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler()

    }

    private fun handler(){
        Handler(Looper.getMainLooper()).post(Runnable {
            go_to_thread.setOnClickListener {
                startActivity(Intent(this, Thread::class.java))
            }
        })

        Handler(Looper.getMainLooper()).post(Runnable {
            go_to_threadhandler.setOnClickListener {
                startActivity(Intent(this, ThreadHandler::class.java))
            }
        })

    }
}