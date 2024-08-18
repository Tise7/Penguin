package com.example.penguin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class FeedThePenguinViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FeedThePenguinUiState())
    val uiState: StateFlow<FeedThePenguinUiState> = _uiState.asStateFlow()

    private var clickEffectJob: Job? = null

    fun onImageClick() {
        when (_uiState.value.currentStep) {
            1 -> _uiState.update {it.copy(currentStep = 2) }
            2 -> {
                _uiState.update {
                    it.copy(
                        currentStep = 3,
                        clickCount = (2..4).random()
                    )
                }
            }
            3 -> {
                val newClickCount = _uiState.value.clickCount - 1
                _uiState.update {
                    it.copy(
                        clickCount = newClickCount,
                        currentStep = if (newClickCount == 0) 4 else 3,
                        showClickEffect = newClickCount == 0
                    )
                }
                if (newClickCount == 0) {
                    startClickEffectTimer()
                }
            }
        }
    }

    private fun startClickEffectTimer() {
        clickEffectJob?.cancel() // Ensure previous job is cancelled
        clickEffectJob = viewModelScope.launch {
            delay(10000)
            _uiState.update { it.copy(showClickEffect = false) }
        }
    }

    fun resetGame() {
        _uiState.update {
            it.copy(
                currentStep = 1,
                clickCount = 0,
                showClickEffect = false
            )
        }
        clickEffectJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        clickEffectJob?.cancel()
    }
}

data class FeedThePenguinUiState(
    val currentStep: Int = 1,
    val clickCount: Int = 0,
    val showClickEffect: Boolean = false
)