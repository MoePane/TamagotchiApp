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


        var happinessLevel = 100
        var hungerLevel = 100
        var cleanlinessLevel = 100
        var RateDecrease = 5
        var IntervalUpdate = 1000

        kin.visibility = View.VISIBLE

        var handler = Handler(Looper.getMainLooper())
        var updateStatusRunnable = object : Runnable{
            override fun run() {
                decreaseStatus()
                handler.postDelayed(this, IntervalUpdate.toLong())
            }

            private fun decreaseStatus() {
                hungerLevel= RateDecrease
                happinessLevel = RateDecrease
                cleanlinessLevel = RateDecrease

                hungerLevel = hungerLevel.coerceAtLeast(0)
                happinessLevel = happinessLevel.coerceAtLeast(0)
                cleanlinessLevel = cleanlinessLevel.coerceAtLeast(0)

                updateUI()
            }

            private fun updateUI() {
                hap.progress = happinessLevel
                hun.progress = hungerLevel
                wash.progress = cleanlinessLevel
            }

        }

        fun onResume() {
            super.onResume()
            handler.postDelayed(updateStatusRunnable,IntervalUpdate.toLong())

        }

        fun onPause() {
            super.onPause()
            handler.removeCallbacks(updateStatusRunnable)
        }




        val imagePackage = intArrayOf(R.drawable.dog_playing1,R.drawable.dog_eating_food, R.drawable.dog_bathing2)
        var index= 0


        fe.setOnClickListener {
            kin.setImageResource(R.drawable.dog_eating_food)
            val currentHunger = hun.progress
            val newHunger = currentHunger + 10
            hun.progress = newHunger.coerceAtMost(100)
        }

        pla.setOnClickListener {
            kin.setImageResource(R.drawable.dog_playing1)
            val currentHunger = hap.progress
            val newHunger = currentHunger + 10
            hap.progress = newHunger.coerceAtMost(100)
        }

        cle.setOnClickListener {
            kin.setImageResource(R.drawable.dog_bathing2)
            val currentHunger = wash.progress
            val newHunger = currentHunger + 10
            wash.progress = newHunger.coerceAtMost(100)
        }






    }


}
