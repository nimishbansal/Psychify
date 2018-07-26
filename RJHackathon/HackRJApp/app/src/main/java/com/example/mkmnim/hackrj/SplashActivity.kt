package com.example.mkmnim.hackrj
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.os.Handler


class SplashActivity : AppCompatActivity()
{

    var SPLASH_DISPLAY_LENGTH = 1000L
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }, SPLASH_DISPLAY_LENGTH)
    }
}