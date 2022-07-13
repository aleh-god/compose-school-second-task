package by.godevelopment.task2_quiz.data.models

data class QuestionModel(
    val question: String,
    val answerOptions: List<String>,
    val correctAnswer: String
)