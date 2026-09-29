package com.example.myapplication.kuis

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityQuizBinding
import com.example.myapplication.databinding.ScoreDialogBinding

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        var questionModelList: List<QuestionModel> = listOf()
        var time: String = ""
    }

    private lateinit var binding: ActivityQuizBinding
    private var currentQuestionIndex = 0
    private var selectedAnswers = mutableListOf<String?>()
    private var answeredCorrectly = mutableListOf<Boolean>()
    private var score = 0
    private var currentLevelId: Int = 0
    private var nextLevelId: Int = 0
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.enableEdgeToEdge()

        currentLevelId = intent.getIntExtra("levelId", 0)
        nextLevelId = currentLevelId + 1

        binding.apply {
            btn0.setOnClickListener(this@QuizActivity)
            btn1.setOnClickListener(this@QuizActivity)
            btn2.setOnClickListener(this@QuizActivity)
            btn3.setOnClickListener(this@QuizActivity)
            nextBtn.setOnClickListener(this@QuizActivity)
            prevBtn.setOnClickListener(this@QuizActivity)
        }

        // Initialize lists
        selectedAnswers = MutableList(questionModelList.size) { null }
        answeredCorrectly = MutableList(questionModelList.size) { false }

        // Load questions and start timer
        loadQuestions()
        startTimer()
    }

    private fun startTimer() {
        val totalTimeInMillis = time.toInt() * 60 * 1000L
        object : CountDownTimer(totalTimeInMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val remainingSeconds = seconds % 60
                binding.timerIndicatorTextview.text = String.format("%02d:%02d", minutes, remainingSeconds)
            }

            override fun onFinish() {
                finishQuiz()
            }
        }.start()
    }

    private fun loadQuestions() {
        if (currentQuestionIndex >= questionModelList.size) {
            finishQuiz()
            return
        }

        val currentQuestion = questionModelList[currentQuestionIndex]

        binding.apply {
            questionIndicatorTextview.text = "Soal ke-${currentQuestionIndex + 1} dari ${questionModelList.size}"
            questionProgressIndicator.progress = ((currentQuestionIndex.toFloat() / questionModelList.size.toFloat()) * 100).toInt()
            questionTextview.text = currentQuestion.soal
            btn0.text = currentQuestion.pilihan[0]
            btn1.text = currentQuestion.pilihan[1]
            btn2.text = currentQuestion.pilihan[2]
            btn3.text = currentQuestion.pilihan[3]
        }

        resetButtonColors()
        val selectedAnswer = selectedAnswers[currentQuestionIndex]
        if (selectedAnswer != null) {
            when (selectedAnswer) {
                binding.btn0.text -> binding.btn0.setBackgroundColor(getColor(R.color.brown))
                binding.btn1.text -> binding.btn1.setBackgroundColor(getColor(R.color.brown))
                binding.btn2.text -> binding.btn2.setBackgroundColor(getColor(R.color.brown))
                binding.btn3.text -> binding.btn3.setBackgroundColor(getColor(R.color.brown))
            }
        }

        binding.prevBtn.visibility = if (currentQuestionIndex == 0) View.GONE else View.VISIBLE
        binding.nextBtn.text = if (currentQuestionIndex == questionModelList.size - 1) "Selesai" else "Soal Berikutnya"
    }

    override fun onClick(view: View?) {
        val clickedBtn = view as Button
        when (clickedBtn.id) {
            R.id.next_btn -> {
                if (selectedAnswers[currentQuestionIndex].isNullOrEmpty()) {
                    Toast.makeText(applicationContext, "Kamu belum memilih jawaban", Toast.LENGTH_SHORT).show()
                    return
                }
                if (!answeredCorrectly[currentQuestionIndex] && selectedAnswers[currentQuestionIndex] == questionModelList[currentQuestionIndex].jawaban) {
                    score++
                    answeredCorrectly[currentQuestionIndex] = true
                    Log.i("Nilai :", score.toString())
                }
                currentQuestionIndex++
                loadQuestions()
            }
            R.id.prev_btn -> {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--
                    loadQuestions()
                }
            }
            else -> {
                selectedAnswers[currentQuestionIndex] = clickedBtn.text.toString()
                resetButtonColors()
                clickedBtn.setBackgroundColor(Color.parseColor("#D5AC97"))
            }
        }

        // Update nextBtn text when moving to the last question
        binding.nextBtn.text = if (currentQuestionIndex == questionModelList.size - 1) "Selesai" else "Soal Berikutnya"
    }

    private fun finishQuiz() {
        showScoreDialog()
        setResult(RESULT_OK)
    }

    private fun showScoreDialog() {
        val totalQuestions = questionModelList.size
        val percentage = ((score.toFloat() / totalQuestions.toFloat()) * 100).toInt()

        val dialogBinding = ScoreDialogBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
        val dialog = builder.create()
        dialog.show()

        dialogBinding.apply {
            scoreProgressIndicator.progress = percentage
            scoreProgressText.text = "$percentage %"
            scoreSubtitle.text = "Kamu benar $score dari $totalQuestions soal"
            if (percentage > 60) {
                playSuccedSound()
                val editor = getSharedPreferences("QuizApp", Context.MODE_PRIVATE).edit()
                editor.putBoolean("Level_${currentLevelId}_Completed", true)
                editor.putBoolean("Level_${nextLevelId}_Unlocked", true)
                editor.apply()
                scoreTitle.text = "Selamat! Kamu berhasil"
                scoreTitle.setTextColor(Color.GREEN)
                nextLevelBg.visibility = View.VISIBLE
                nextLevelBtn.setOnClickListener {
                    val intent = Intent()
                    intent.putExtra("nextLevelId", nextLevelId)
                    setResult(RESULT_OK, intent)
                    finish()
                }
                explanationBg.visibility = View.VISIBLE
                explanationBtn.setOnClickListener {
                    val answerKeyIntent = Intent(this@QuizActivity, AnswerKeyActivity::class.java)
                    answerKeyIntent.putExtra("levelId", currentLevelId)
                    startActivity(answerKeyIntent)
                }
                retryBtn.setOnClickListener {
                    dialog.dismiss()
                    restartQuiz(currentLevelId)
                }
                retryBtn.visibility = View.VISIBLE
            } else {
                playFailSound()
                scoreTitle.text = "Maaf, kamu belum berhasil"
                scoreTitle.setTextColor(Color.RED)
                retryBtn.setOnClickListener {
                    dialog.dismiss()
                    restartQuiz(currentLevelId)
                }
                retryBtn.visibility = View.VISIBLE
            }
            finishBtn.setOnClickListener {
                dialog.dismiss()
                setResult(RESULT_OK)
                finish()
            }
        }
    }

    private fun playFailSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.game_fail)
        mediaPlayer?.start()
    }

    private fun playSuccedSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.game_succed)
        mediaPlayer?.start()
    }

    private fun resetButtonColors() {
        binding.apply {
            btn0.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            btn1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            btn2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            btn3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
    }

    private fun restartQuiz(currentLevelId: Int) {
        // Reset quiz state
        currentQuestionIndex = 0
        score = 0
        selectedAnswers = MutableList(questionModelList.size) { null }
        answeredCorrectly = MutableList(questionModelList.size) { false }

        // Reload questions and start timer
        loadQuestions()
        startTimer()
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi")
            .setMessage("Apakah Kamu yakin ingin keluar dari kuis ini?")
            .setPositiveButton("Ya") { dialog, which ->
                super.onBackPressed()
            }
            .setNegativeButton("Tidak", null)

        val alertDialog = builder.create()

        alertDialog
        alertDialog.show()
    }
}
