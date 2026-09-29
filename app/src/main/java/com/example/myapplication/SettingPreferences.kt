package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SettingsPreferences {

    private const val SHOW_MUSIC_ONOFF = "show_music_enable_disable"
    private const val IS_LOGGED_IN = "is_logged_in"

    fun setMusicEnableDisable(context: Context, result: Boolean) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        prefsEditor.putBoolean(SHOW_MUSIC_ONOFF, result)
        prefsEditor.apply()
    }

    fun getMusicEnableDisable(context: Context): Boolean {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(SHOW_MUSIC_ONOFF, Constants.DEFAULT_MUSIC_SETTING)
    }

    fun setLoggedIn(context: Context, isLoggedIn: Boolean) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        prefsEditor.putBoolean(IS_LOGGED_IN, isLoggedIn)
        prefsEditor.apply()
    }

    fun getIsLoggedIn(context: Context): Boolean {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }
}
