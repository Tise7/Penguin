package com.example.penguin.data

import androidx.annotation.StringRes

data class Question(
    @StringRes val question: Int,
    @StringRes val options: List<Int>,
    @StringRes val correctAnswer: Int
)

//data class QuizUiState(
//    val questions: List<Question> = emptyList(),
//    val currentQuestionIndex: Int = 0,
//    val selectedOptionIndex: Int? = null,
//    val score: Int = 0,
//    val showResult: Boolean = false
//)