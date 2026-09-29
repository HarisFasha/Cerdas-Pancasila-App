package com.example.myapplication.puzzle

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.AppController
import com.example.myapplication.R
import org.json.JSONArray
import java.io.IOException

class ExplanationActivity : AppCompatActivity() {
    private val explanationsMap: MutableMap<String?, Explanation> = HashMap()
    private var mediaPlayer: MediaPlayer? = null
    private var isAudioPlaying = false
    private lateinit var audioFileName: String
    private lateinit var zoomIn: Animation
    private var completedImageName: String? = null
    private var wasAppControllerSoundPlaying = false // Track if AppController sound was playing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explanation)

        val imageViewExplanation = findViewById<ImageView>(R.id.imageViewExplanation)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val textViewExplanation = findViewById<TextView>(R.id.textViewExplanation)
        val buttonNextLevel = findViewById<ImageButton>(R.id.buttonNextLevel)
        val buttonRepeatLevel = findViewById<ImageButton>(R.id.buttonRepeatLevel)
        val buttonBack = findViewById<ImageButton>(R.id.buttonBack)
        val buttonPlayAudio = findViewById<ImageButton>(R.id.buttonPlayAudio)

        this.enableEdgeToEdge()

        // Load explanations from JSON
        loadExplanationsFromJson()

        zoomIn = AnimationUtils.loadAnimation(this, R.anim.button_zoom)

        val intent = intent
        completedImageName = intent.getStringExtra("completedImageName")
        val nextLevelId = intent.getIntExtra("nextLevelId", -1)

        // Assuming the image is stored in the assets/img folder
        try {
            val `is` = assets.open("img/$completedImageName")
            val bitmap = BitmapFactory.decodeStream(`is`)
            imageViewExplanation.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // Set title and explanation text based on the completed image
        val explanation = explanationsMap[completedImageName]
        if (explanation != null) {
            textViewTitle.text = explanation.title
            textViewExplanation.text = explanation.description
        }

        // Set the audio file name based on the completed image name
        if (completedImageName != null) {
            audioFileName = completedImageName!!.replace(".png", "")
        } // Remove the .png extension

        // Button click listeners
        buttonNextLevel.setOnClickListener {
            // Handle navigation to the next level
            val intent = Intent()
            intent.putExtra("nextLevelId", nextLevelId)
            setResult(RESULT_OK, intent)
            finish()

        }

        buttonRepeatLevel.setOnClickListener {
            // Restart the current activity
            restartPuzzleActivity()
        }


        buttonBack.setOnClickListener {
            // Go back to the previous activity
            setResult(RESULT_OK)
            finish()
        }

        buttonPlayAudio.setOnClickListener {
            toggleAudio(buttonPlayAudio)
        }

        setZoomEffect(buttonNextLevel)
        setZoomEffect(buttonBack)
        setZoomEffect(buttonRepeatLevel)
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

    private fun loadExplanationsFromJson() {
        try {
            val `is` = assets.open("explanations.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            val json = String(buffer, charset("UTF-8"))
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val imageName = jsonObject.getString("imageName")
                val title = jsonObject.getString("title")
                val description = jsonObject.getString("description")
                explanationsMap[imageName] = Explanation(title, description)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun restartPuzzleActivity() {
        // Restart the PuzzleActivity with the completed image name
        val intent = Intent(this, PuzzleActivity::class.java)
        intent.putExtra("assetName", completedImageName) // Pass the completed image name
        startActivity(intent)
        finish() // Finish the ExplanationActivity
    }
    private fun toggleAudio(button: ImageButton) {
        if (isAudioPlaying) {
            // Stop and release the media player
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
            button.setImageResource(R.drawable.icon_sound_on) // Change to play icon
            isAudioPlaying = false

            // Resume sound from AppController if it was playing before
            if (wasAppControllerSoundPlaying) {
                AppController.playMusic()
            }
        } else {
            // Check if AppController's sound was playing before
            wasAppControllerSoundPlaying = AppController.isMusicPlaying // Method to check if sound is playing

            // Stop any currently playing sound from AppController
            AppController.stopSound()

            // Release any existing media player
            mediaPlayer?.release()

            // Get the audio resource ID dynamically
            val audioResId = resources.getIdentifier(audioFileName, "raw", packageName)
            if (audioResId != 0) {
                mediaPlayer = MediaPlayer.create(this, audioResId)

                // Start playback
                mediaPlayer?.start()

                // Set up a listener to release the media player when done
                mediaPlayer?.setOnCompletionListener {
                    mediaPlayer?.release()
                    mediaPlayer = null
                    button.setImageResource(R.drawable.icon_sound_on) // Change to play icon
                    isAudioPlaying = false

                    // Resume sound from AppController if it was playing before
                    if (wasAppControllerSoundPlaying) {
                        AppController.playMusic()
                    }
                }

                // Change button image to indicate audio is playing
                button.setImageResource(R.drawable.icon_sound_off) // Change to pause icon
                isAudioPlaying = true
            } else {
                // Handle case where the audio resource is not found
                Toast.makeText(this, "Audio file not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release media player resources when the activity is destroyed
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private class Explanation internal constructor(var title: String, var description: String)
}
