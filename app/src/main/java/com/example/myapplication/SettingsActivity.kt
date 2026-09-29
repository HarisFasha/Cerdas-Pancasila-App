package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var mContext: Context
    private lateinit var mMusicCheckBox: Switch
  //  private lateinit var mNightModeSwitch: Switch
    private lateinit var okBtn: Button
    private lateinit var logoutButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        this.enableEdgeToEdge()
        mAuth = FirebaseAuth.getInstance()
        mContext = this
        AppController.currentActivity = this

        initViews()

        populateMusicEnableContents()
        populateNightModeSwitch()
        sharedPreferences = getSharedPreferences("QuizApp", Context.MODE_PRIVATE)

        // Load user data from shared preference
        val name = sharedPreferences.getString("name", null) ?: ""
        val age = sharedPreferences.getInt("age", 0)
        val grade = sharedPreferences.getString("grade", null) ?: ""
        val lastIndexGrade = grade.last()
//
//        // Display the user's name and grade on the screen
        findViewById<TextView>(R.id.name_textview).text = name
        findViewById<TextView>(R.id.grade_textview).text = lastIndexGrade.toString()

    }



    private fun initViews() {
        mMusicCheckBox = findViewById(R.id.music_checkbox)
        mMusicCheckBox.isChecked = true
        mMusicCheckBox.setOnCheckedChangeListener { _, _ ->
            switchMusicEnableCheckbox()
        }

//        mNightModeSwitch = findViewById(R.id.night_mode_switch)
//        mNightModeSwitch.setOnCheckedChangeListener { _, isChecked ->
//            switchNightMode(isChecked)
//        }

        okBtn = findViewById(R.id.bt_settings)
        okBtn.setOnClickListener {
            goToPlayScreen()
        }

//        logoutButton = findViewById(R.id.logout_btn)
//        logoutButton.setOnClickListener {
//            mAuth.signOut()
//            val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
    }

    private fun goToPlayScreen() {
        val intentPlayScreen = Intent(this@SettingsActivity, AppScreen::class.java)
        startActivity(intentPlayScreen)
        finish()
    }
    private fun goToContact() {
        val intentPlayScreen = Intent(this@SettingsActivity, AppScreen::class.java)
        startActivity(intentPlayScreen)
        finish()
    }

    private fun switchMusicEnableCheckbox() {
        val isMusicOn = mMusicCheckBox.isChecked
        if (isMusicOn) {
            SettingsPreferences.setMusicEnableDisable(mContext, true)
            AppController.playMusic()
        } else {
            SettingsPreferences.setMusicEnableDisable(mContext, false)
            AppController.stopSound()
        }

        populateMusicEnableContents()
    }

    private fun switchNightMode(isNightModeEnabled: Boolean) {
        if (isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        // Save the night mode state in shared preferences
        val sharedPreferences = getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("NightMode", isNightModeEnabled)
        editor.apply()
    }

    private fun populateMusicEnableContents() {
        if (SettingsPreferences.getMusicEnableDisable(mContext)) {
            AppController.playMusic()
            mMusicCheckBox.isChecked = true
        } else {
            AppController.stopSound()
            mMusicCheckBox.isChecked = false
        }
    }

    private fun populateNightModeSwitch() {
        val sharedPreferences = getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        val isNightModeEnabled = sharedPreferences.getBoolean("NightMode", false)
       // mNightModeSwitch.isChecked = isNightModeEnabled
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@SettingsActivity, AppScreen::class.java)
        startActivity(intent)
        finish()
    }
}
