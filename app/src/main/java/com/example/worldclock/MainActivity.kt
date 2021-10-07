package com.example.worldclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldclock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()

        binding.testTextView.text = Clock().getTimeByTimeZoneId(ClockLocale.US_INDIANASTARKE)
    }

    private fun setBindings() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}