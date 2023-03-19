package com.example.chronometersapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.chronometersapp.databinding.ActivityCronometerHomeBinding

class CronometerHome : AppCompatActivity() {
      lateinit var binding: ActivityCronometerHomeBinding
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityCronometerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

           var pauseTime:Long = 0
          binding.buttonstart.setOnClickListener{
          binding.chronometer.base= SystemClock.elapsedRealtime()+pauseTime
          binding.chronometer.start()
          binding.buttonstart.visibility=View.GONE
          binding.buttonpause.visibility=View.VISIBLE
          binding.imageView8.setImageDrawable(getDrawable(R.drawable.pausee))

        }
          binding.buttonpause.setOnClickListener{
              pauseTime = binding.chronometer.base-SystemClock.elapsedRealtime()
              binding.chronometer.stop()
              binding.buttonpause.visibility =View.GONE
              binding.buttonstart.visibility = View.VISIBLE
              binding.imageView8.setImageDrawable(getDrawable(R.drawable.startt))
          }
          binding.buttonreset.setOnClickListener {
              binding.chronometer.base = SystemClock.elapsedRealtime()
              pauseTime = 0
              binding.chronometer.stop()
              binding.buttonpause.visibility = View.GONE
              binding.buttonstart.visibility = View.VISIBLE
              binding.imageView8.setImageDrawable(getDrawable(R.drawable.startt))

          }

    }
}