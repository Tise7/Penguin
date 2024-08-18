package com.example.penguin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.penguin.data.FoodItem
import com.example.penguin.data.PenguinSpecies
import com.example.penguin.data.getPenguinSpecies
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PenguinGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PenguinGameState())
    val uiState: StateFlow<PenguinGameState> = _uiState.asStateFlow()

    fun selectPenguin(penguin: PenguinSpecies) {
        _uiState.value = _uiState.value.copy(
            selectedPenguin = penguin,
            currentHappiness = 0
        )
    }

    fun feedPenguin(foodItem: FoodItem) {
        val currentPenguin = _uiState.value.selectedPenguin
        currentPenguin?.let { penguin ->
            val multiplier = penguin.foodPreferences[foodItem] ?: 1
            val newHappiness = minOf(
                penguin.maxHappiness,
                penguin.happinessLevel + (foodItem.nutritionalValue * multiplier)
            )
            _uiState.value = _uiState.value.copy(
                selectedPenguin = penguin.copy(happinessLevel = newHappiness),
                currentHappiness = newHappiness
            )

            if (newHappiness >= penguin.maxHappiness) {
                triggerClickEffect()
            }
        }
    }


    private fun triggerClickEffect() {
        _uiState.value = _uiState.value.copy(showClickEffect = true)
        viewModelScope.launch {
            delay(1000)
            _uiState.value = _uiState.value.copy(
                showClickEffect = false,
                finalDialogShow = true
            )
        }
    }

    fun resetGame() {
        _uiState.value = PenguinGameState()
    }
}

data class PenguinGameState(
    val penguinSpecies: List<PenguinSpecies> = getPenguinSpecies(),
    val selectedPenguin: PenguinSpecies? = null,
    val currentHappiness: Int = 0,
    val showClickEffect: Boolean = false,
    val finalDialogShow: Boolean = false
)