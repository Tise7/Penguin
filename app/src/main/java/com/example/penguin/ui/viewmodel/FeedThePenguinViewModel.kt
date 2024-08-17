package com.example.penguin.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class FeedThePenguinViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FeedThePenguinUiState())
    val uiState: StateFlow<FeedThePenguinUiState> = _uiState.asStateFlow()

    fun onImageClick() {
        when (_uiState.value.currentStep) {
            1 -> _uiState.update {it.copy(currentStep = 2) }
            2 -> {
                _uiState.update {
                    it.copy(
                        currentStep = 3,
                        clickCount = (5..9).random()
                    )
                }
            }
            3 -> {
                val newClickCount = _uiState.value.clickCount - 1
                _uiState.update {
                    it.copy(
                        clickCount = newClickCount,
                        currentStep = if (newClickCount == 0) 4 else 3
                    )}
            }
            4 ->  {}
        }
    }

    fun resetGame() {
        _uiState.update { it.copy(currentStep = 1, clickCount = 0) }
    }
}

data class FeedThePenguinUiState(
    val currentStep: Int = 1,
    val clickCount: Int = 0
)