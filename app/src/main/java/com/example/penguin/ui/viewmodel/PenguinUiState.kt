package com.example.penguin.ui.viewmodel

import com.example.penguin.data.Penguin
import com.example.penguin.data.PenguinDataProvider

data class PenguinUiState(
    val penguinList: List<Penguin> = emptyList(),
    val currentPenguin: Penguin? = null
)
