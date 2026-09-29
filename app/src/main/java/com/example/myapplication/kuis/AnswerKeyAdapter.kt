package com.example.myapplication.kuis


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class AnswerKeyAdapter(private val questionList: List<QuestionModel>) : RecyclerView.Adapter<AnswerKeyAdapter.AnswerKeyViewHolder>() {

    class AnswerKeyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewQuestion: TextView = itemView.findViewById(R.id.textViewQuestion)
        val textViewCorrectAnswer: TextView = itemView.findViewById(R.id.textViewCorrectAnswer)
        val textViewExplain: TextView = itemView.findViewById(R.id.textViewExplain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerKeyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_answer_key, parent, false)
        return AnswerKeyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnswerKeyViewHolder, position: Int) {
        val question = questionList[position]
        holder.textViewQuestion.text = question.soal
        holder.textViewCorrectAnswer.text = "Jawaban Benar: ${question.jawaban}"
        holder.textViewExplain.text = "Pembahasan : ${question.pembahasan}"
    }

    override fun getItemCount() = questionList.size
}
