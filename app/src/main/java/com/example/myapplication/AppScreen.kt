package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.kuis.MainActivity

class AppScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var btPlayQuiz: ImageButton
    private lateinit var btSettings: ImageButton
    private lateinit var btInfo: ImageButton
    private var backPressedTime: Long = 0

    private lateinit var zoomIn: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_screen)
        this.enableEdgeToEdge()

        // Load zoom animation
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.button_zoom)

        // Initialize buttons
        btPlayQuiz = findViewById(R.id.bt_playQuiz)
        btSettings = findViewById(R.id.bt_settings)
        btInfo = findViewById(R.id.bt_info)

        // Set click listeners
        btPlayQuiz.setOnClickListener(this)
        btSettings.setOnClickListener(this)
        btInfo.setOnClickListener(this)

        // Set touch listeners for zoom effect
        setZoomEffect(btPlayQuiz)
        setZoomEffect(btSettings)
        setZoomEffect(btInfo)

        // Initialize AppController
        AppController.currentActivity = this
        AppController.initialize(this)

        // Check and play music if enabled
        if (SettingsPreferences.getMusicEnableDisable(applicationContext)) {
            try {
                AppController.playMusic()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }

        // Handle back button press
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AppController.stopSound()

                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    finish() // Exit the activity
                } else {
                    Toast.makeText(
                        this@AppScreen,
                        "Tekan sekali lagi untuk keluar",
                        Toast.LENGTH_SHORT
                    ).show()
                    backPressedTime = System.currentTimeMillis()
                }
            }
        })
    }

    private fun setZoomEffect(button: ImageButton) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.startAnimation(zoomIn)
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.clearAnimation()
            }
            false
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bt_playQuiz -> {
                val playIntent = Intent(this@AppScreen, MainActivity::class.java)
                startActivity(playIntent)
                finish()
            }
            R.id.bt_settings -> {
                val settingIntent = Intent(this@AppScreen, SettingsActivity::class.java)
                startActivity(settingIntent)
                finish()
            }
            R.id.bt_info -> {
                val infoIntent = Intent(this@AppScreen, InfoActivity::class.java)
                startActivity(infoIntent)
                finish()
            }
        }
    }
}
