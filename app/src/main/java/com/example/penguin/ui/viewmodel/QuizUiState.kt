package com.example.penguin.ui.viewmodel

import com.example.penguin.data.Questions

data class QuizUiState(
    val questions: List<Questions> = emptyList(),
    val currentQuestions: Questions? = null,
    val currentQuestionIndex: Int = 0,
    val currentPenguinIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isAnswerCorrect: Boolean? = null,
    val score: Int = 0,
    val showResult: Boolean = false
)