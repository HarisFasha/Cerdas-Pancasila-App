package com.example.myapplication.kuis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.level.QuestionRepository

class AnswerKeyActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var answerKeyAdapter: AnswerKeyAdapter
    private lateinit var questionList: MutableList<QuestionModel>
    private var currentLevelId = 0 // default levelId

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_key)
        this.enableEdgeToEdge()
        recyclerView = findViewById(R.id.recyclerViewAnswerKey)
        recyclerView.layoutManager = LinearLayoutManager(this)

        questionList = mutableListOf()

        // Check if the activity is started with a specific levelId
        if (intent != null && intent.hasExtra("levelId")) {
            currentLevelId = intent.getIntExtra("levelId", 0)
        }

        // Fetch questions from QuestionRepository
        questionList.addAll(QuestionRepository.getQuestions(currentLevelId))

        // Setup RecyclerView Adapter
        answerKeyAdapter = AnswerKeyAdapter(questionList)
        recyclerView.adapter = answerKeyAdapter
    }
}
