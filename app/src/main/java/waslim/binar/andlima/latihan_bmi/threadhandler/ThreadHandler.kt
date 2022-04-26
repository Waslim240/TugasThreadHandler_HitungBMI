package waslim.binar.andlima.latihan_bmi.threadhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_thread.hasilHitung
import kotlinx.android.synthetic.main.activity_thread.hitung
import kotlinx.android.synthetic.main.activity_thread.masukanBeratBadan
import kotlinx.android.synthetic.main.activity_thread.masukanTinggiBadan
import waslim.binar.andlima.latihan_bmi.R

class ThreadHandler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_handler)

        threadhandler()
    }


    private fun threadhandler(){

        val handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val message2 = msg.obj as String
                hasilHitung.text = message2
            }
        }


        Thread(Runnable {
            hitung.setOnClickListener {
                val bb = masukanBeratBadan.text.toString().toDouble()
                val tb = masukanTinggiBadan.text.toString().toDouble()

                // ubah tinggi ke cm
                val tinggiBadan = tb / 100

                //rumus hitung bmi
                val hitungBmi = bb / (tinggiBadan * tinggiBadan)

                val hasil = when {
                    hitungBmi < 18.4 -> {
                        "Hasil : Kurus"
                    }
                    hitungBmi > 18.5 && hitungBmi < 24.9 -> {
                        "Hasil : Normal"
                    }
                    hitungBmi > 25 && hitungBmi < 29.9 -> {
                        "Hasil : Overweight"
                    }
                    else -> {
                        "Hasil : Obesitas"
                    }
                }

                val message = Message.obtain()
                message.obj = "Berat Badan : $bb\nTinggi Badan : $tb\nHasil : $hasil"
                message.target = handler
                message.sendToTarget()
            }
        }).start()

    }

}