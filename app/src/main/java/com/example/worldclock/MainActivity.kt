package com.example.worldclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.worldclock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()

        start()
    }

    private fun start() {
        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        sleep(1000)
                        runOnUiThread { updateText() }
                    }
                } catch (e: InterruptedException) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }; t.start()
    }
    private fun updateText() {
        binding.timeZoneTitle.text = ClockLocale.US_INDIANASTARKE.id
        binding.timeZoneValue.text = Clock().getTimeByTimeZoneId(ClockLocale.US_INDIANASTARKE)
    }

    private fun setBindings() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}