package com.example.penguin.ui.viewmodel

import com.example.penguin.data.Penguin

data class PenguinUiState(
    val penguinList: List<Penguin> = emptyList(),
    val currentPenguin: Penguin? = null
)
