package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("StaticFieldLeak")
object AppController {

    private lateinit var mContext: Context
    private var player: MediaPlayer? = null
    var isMusicPlaying = false
    lateinit var currentActivity: AppCompatActivity

    fun initialize(context: Context) {
        mContext = context.applicationContext
        if (player == null) {
            mediaPlayerInitializer()
        }
    }

    private fun mediaPlayerInitializer() {
        player = MediaPlayer.create(mContext, R.raw.background).apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            isLooping = true
            setVolume(1f, 1f) // Default volume level (max)
        }
    }

    fun playMusic() {
        if (player == null) {
            mediaPlayerInitializer() // Initialize player if not already done
        }
        if (!isMusicPlaying) {
            player?.start()
            isMusicPlaying = true
        }
    }

    fun stopSound() {
        if (isMusicPlaying) {
            player?.pause()
            isMusicPlaying = false
        }
    }

    fun releasePlayer() {
        player?.release()
        player = null
        isMusicPlaying = false
    }
}
