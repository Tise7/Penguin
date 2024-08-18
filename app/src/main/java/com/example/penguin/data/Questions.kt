package com.example.penguin.data

import androidx.annotation.StringRes

data class Questions(
    @StringRes val question: Int,
    @StringRes val options: List<Int>,
    @StringRes val correctAnswer: Int
)