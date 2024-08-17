package com.example.penguin.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.penguin.data.PenguinDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PenguinViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PenguinUiState())
    val uiState: StateFlow<PenguinUiState> = _uiState.asStateFlow()

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        _uiState.value = PenguinUiState(
            penguinList = PenguinDataProvider.getPenguinData(),
        )
    }

}