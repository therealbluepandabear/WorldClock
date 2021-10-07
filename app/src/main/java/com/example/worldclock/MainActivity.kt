package com.example.worldclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.worldclock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var locale = ClockLocale.US_INDIANASTARKE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()

        start()

        binding.timeZoneTitle.text = ClockLocale.US_INDIANASTARKE.label

        binding.moveForward.setOnClickListener {
            locale = ClockLocale.timeZoneList.random()
        }
    }

    private fun start() {
        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        sleep(1)
                        runOnUiThread { updateText() }
                    }
                } catch (e: InterruptedException) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }
        };
        t.name = locale.id
        t.start()
    }
    private fun updateText() {
        binding.timeZoneTitle.text = locale.label
        binding.timeZoneValue.text = Clock().getTimeByTimeZoneId(locale)
    }

    private fun setBindings() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}