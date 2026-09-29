package com.example.myapplication.kuis

data class QuizModel(
    val id: Int,
    val level: String,
    val time: String,
    val questionList: List<QuestionModel>,
    val assetName: String, // Ensure this property is included
    val title: String,
    val description: String,
    val isPuzzle : Boolean
) {
    constructor() : this(0, "", "", emptyList(), "", "", "",true)
}

data class QuestionModel(
    val soal: String,
    val pilihan: List<String>,
    val jawaban: String,
    val pembahasan:String
) {
    constructor() : this("", emptyList(), "","")
}
