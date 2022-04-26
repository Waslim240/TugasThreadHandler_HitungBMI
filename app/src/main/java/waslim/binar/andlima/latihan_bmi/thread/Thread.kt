package waslim.binar.andlima.latihan_bmi.thread

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_thread.*
import waslim.binar.andlima.latihan_bmi.R

class Thread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        thread()

    }


    @SuppressLint("SetTextI18n")
    private fun thread(){
        Thread(Runnable {

            hitung.setOnClickListener {
                val bb = masukanBeratBadan.text.toString().toDouble()
                val tb = masukanTinggiBadan.text.toString().toDouble()

                // ubah tinggi badan ke cm
                val tinggiBadan = tb / 100

                // rumus hitung bmi
                val hitungBmi = bb / (tinggiBadan * tinggiBadan)

                hasilHitung.post(Runnable {
                    when {
                        hitungBmi < 18.5 -> {
                            hasilHitung.text = "Berat Badan : $bb\nTinggi Badan : $tb\nHasil : Kurus"
                        }
                        hitungBmi > 18.5 && hitungBmi < 24.9 -> {
                            hasilHitung.text = "Berat Badan : $bb\nTinggi Badan : $tb\nHasil : Normal"
                        }
                        hitungBmi > 25 && hitungBmi < 29.9 -> {
                            hasilHitung.text = "Berat Badan : $bb\nTinggi Badan : $tb\nHasil : Overweight"
                        }
                        else -> {
                            hasilHitung.text = "Berat Badan : $bb\nTinggi Badan : $tb\nHasil : Obesitas"
                        }
                    }
                })

            }

        }).start()
    }
}