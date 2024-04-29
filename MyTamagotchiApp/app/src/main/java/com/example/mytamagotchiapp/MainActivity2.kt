package com.example.mytamagotchiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Switch

class MainActivity2 : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var decreaseSeekBarRunnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var fe = findViewById<Button>(R.id.btnFe)
        var pla = findViewById<Button>(R.id.btnPla)
        var cle = findViewById<Button>(R.id.btnCle)
        var kin = findViewById<ImageView>(R.id.ivKing2)
        var hap = findViewById<SeekBar>(R.id.sbHap)
        var hun = findViewById<SeekBar>(R.id.sbHun)
        var wash = findViewById<SeekBar>(R.id.sbCle)



        kin.visibility = View.VISIBLE

        handler = Handler()
        decreaseSeekBarRunnable = Runnable {

            val currentProgress = hap.progress
            if (currentProgress > 0) {
                hap.progress = currentProgress - 1

                val currentProgress1 = hun.progress
                if (currentProgress1 > 0) {
                    hun.progress = currentProgress1 - 1
                }

                val currentProgress2 = wash.progress
                if (currentProgress2 > 0) {
                    wash.progress = currentProgress2 - 1
                }

            } else {
                handler.removeCallbacks(decreaseSeekBarRunnable)
            }

            handler.postDelayed(decreaseSeekBarRunnable, 1000)
        }

        handler.post(decreaseSeekBarRunnable)





        val imagePackage = intArrayOf(R.drawable.dog_playing1,R.drawable.dog_eating_food, R.drawable.dog_bathing2)
        var index= 0


        fe.setOnClickListener {
            kin.setImageResource(R.drawable.dog_eating_food)
            val currenthunger = hun.progress
            val newhunger = currenthunger + 10
            hun.progress = newhunger.coerceAtMost(100)
        }

        pla.setOnClickListener {
            kin.setImageResource(R.drawable.dog_playing1)
            val currenthappiness = hap.progress
            val newhappiness = currenthappiness + 10
            hap.progress = newhappiness.coerceAtMost(100)
        }

        cle.setOnClickListener {
            kin.setImageResource(R.drawable.dog_bathing2)
            val currentCleanliness = wash.progress
            val newCleanliness = currentCleanliness + 10
            wash.progress = newCleanliness.coerceAtMost(100)
        }





    }


}
