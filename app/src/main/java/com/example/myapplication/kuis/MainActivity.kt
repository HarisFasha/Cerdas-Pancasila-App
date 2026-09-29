package com.example.myapplication.kuis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.AppScreen
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.level.QuizAdapter
import com.example.myapplication.level.QuestionRepository
import com.example.myapplication.puzzle.PuzzleActivity
import java.io.IOException

class MainActivity : AppCompatActivity(), QuizAdapter.QuizLevelClickListener, QuizAdapter.PuzzleLevelClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var levelsList: MutableList<QuizModel>
    private var imageFiles: Array<String>? = null

    private val REQUEST_CODE_QUIZ = 1
    private val REQUEST_CODE_PUZZLE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.enableEdgeToEdge()
        levelsList = mutableListOf()
        loadLevels()
        loadImagesFromAssets()
    }

    private fun loadLevels() {
        levelsList = mutableListOf(
            QuizModel(1, "Level 1", "5", QuestionRepository.getQuestions(1), "", "", "", false),
            QuizModel(2, "Level 2", "5", QuestionRepository.getQuestions(2), "", "", "", false),
            QuizModel(
                3,
                "Level 3",
                "3",
                QuestionRepository.getQuestions(3),
                "image1.png",
                "",
                "",
                true
            ),
            QuizModel(4, "Level 4", "5", QuestionRepository.getQuestions(4), "", "", "", false),
            QuizModel(5, "Level 5", "5", QuestionRepository.getQuestions(5), "", "", "", false),
            QuizModel(
                6,
                "Level 6",
                "3",
                QuestionRepository.getQuestions(6),
                "image2.png",
                "",
                "",
                true
            ),
            QuizModel(7, "Level 7", "5", QuestionRepository.getQuestions(7), "", "", "", false),
            QuizModel(8, "Level 8", "5", QuestionRepository.getQuestions(8), "", "", "", false),
            QuizModel(
                9,
                "Level 9",
                "3",
                QuestionRepository.getQuestions(6),
                "image3.png",
                "",
                "",
                true
            ),
            QuizModel(10, "Level 10", "5", QuestionRepository.getQuestions(10), "", "", "", false),
        )
        setupRecyclerView()
    }

    private fun loadImagesFromAssets() {
        try {
            imageFiles = assets.list("img")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val highScores = loadHighScores()
        val adapter = QuizAdapter(levelsList, this, this, this::isLevelUnlocked)
        adapter.setHighScores(highScores)
        binding.recyclerView.adapter = adapter
    }

    override fun onQuizLevelClick(level: QuizModel) {
        val intent = Intent(this, QuizActivity::class.java)
        QuizActivity.questionModelList = level.questionList
        QuizActivity.time = level.time
        intent.putExtra("levelId", level.id.toInt())
        startActivityForResult(intent, REQUEST_CODE_QUIZ)
    }

    override fun onPuzzleLevelClick(level: QuizModel) {
        val intent = Intent(this, PuzzleActivity::class.java)
        intent.putExtra("levelId", level.id)
        intent.putExtra("assetName", level.assetName)
        startActivityForResult(intent, REQUEST_CODE_PUZZLE)
    }

    private fun isLevelUnlocked(levelIndex: Int): Boolean {
        val sharedPref = getSharedPreferences("QuizApp", Context.MODE_PRIVATE)
        if (levelIndex == 0) {
            return true // Level pertama selalu terbuka
        }
        return sharedPref.getBoolean("Level_${levelIndex}_Completed", false)
    }

    private fun loadHighScores(): Map<Int, Int> {
        val sharedPref = getSharedPreferences("QuizApp", Context.MODE_PRIVATE)
        val highScores = mutableMapOf<Int, Int>()
        for (i in levelsList.indices) {
            val highScore = sharedPref.getInt("HighScore_Level_$i", 0)
            highScores[i] = highScore
        }
        return highScores
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_QUIZ || requestCode == REQUEST_CODE_PUZZLE) {
                loadLevels()
                binding.recyclerView.adapter?.notifyDataSetChanged()
                val nextLevelId = data?.getIntExtra("nextLevelId", -1)
                if (nextLevelId != null && nextLevelId != -1) {
                    val nextLevel = levelsList.find { it.id == nextLevelId }
                    if (nextLevel != null) {
                        if (nextLevel.isPuzzle) {
                            onPuzzleLevelClick(nextLevel)
                        } else {
                            onQuizLevelClick(nextLevel)
                        }
                    }
                    // Reload levels and update the adapter

                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@MainActivity, AppScreen::class.java)
        startActivity(intent)
        finish()
    }
}
