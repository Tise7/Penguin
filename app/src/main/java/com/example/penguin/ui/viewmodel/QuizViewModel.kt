package com.example.penguin.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.penguin.data.QuestionsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState:StateFlow<QuizUiState> = _uiState.asStateFlow()

    private var currentQuestionIndex = 0

    init {
        loadQuestions(0)
    }

    fun loadQuestions(penguinIndex: Int) {
        val allQuestions = QuestionsDataProvider.getPenguinQuiz()
        val currentPenguinQuestions = allQuestions.getOrNull(penguinIndex) ?: emptyList()

        _uiState.update {
            it.copy(
                questions = currentPenguinQuestions,
                currentQuestions = currentPenguinQuestions.getOrNull(0),
                currentQuestionIndex = 0,
                currentPenguinIndex = penguinIndex,
                selectedOptionIndex = null,
                isAnswerCorrect = null,
                score = 0,
                showResult = false
            )
        }}

    fun onOptionSelected(selectedOptionIndex: Int) {
        val currentQuestion = _uiState.value.currentQuestions ?: return
        val isCorrect = currentQuestion.options[selectedOptionIndex] == currentQuestion.correctAnswer

        _uiState.update {
            it.copy(
                selectedOptionIndex = selectedOptionIndex,
                isAnswerCorrect = isCorrect,
                score = if (isCorrect) it.score + 1 else it.score
            )
        }
    }

    fun onNextButtonClicked() {
        currentQuestionIndex = _uiState.value.currentQuestionIndex
        if (currentQuestionIndex++ < _uiState.value.questions.size - 1) {
            _uiState.update {
                it.copy(
                    currentQuestionIndex = currentQuestionIndex,
                    currentQuestions = it.questions.getOrNull(currentQuestionIndex),
                    selectedOptionIndex = null,
                    isAnswerCorrect = null
                )
            }
        }
    }

    fun onPreviousButtonClicked() {
        currentQuestionIndex = _uiState.value.currentQuestionIndex
        if (currentQuestionIndex-- > 0) {
            _uiState.update {
                it.copy(
                    currentQuestionIndex = currentQuestionIndex,
                    currentQuestions = it.questions.getOrNull(currentQuestionIndex),
                    isAnswerCorrect = null
                )
            }
        }
    }

    fun onSubmitButtonClicked() {
        _uiState.update { it.copy(showResult = true) }
    }

    fun onRetryButtonClicked() {
        _uiState.update {
            it.copy(
                selectedOptionIndex = null,
                isAnswerCorrect = null,
                score = 0,
                showResult = false
            )
        }

        val penguinIndex = _uiState.value.currentPenguinIndex
        loadQuestions(penguinIndex)

        _uiState.update {
            it.copy(
                currentQuestionIndex = 0,
                currentQuestions = it.questions.getOrNull(0)
            )
        }
    }
}
