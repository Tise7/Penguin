package com.example.penguin.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Penguin(
    val id: Int,
    @StringRes val penguinName: Int,
    @StringRes val description: Int,
    @StringRes val lifestyleAndHabitat: Int,
    @StringRes val diet: Int,
    @StringRes val sizeAndWeight: Int,
    @StringRes val relationships: Int,
    @StringRes val historyAndLifespan: Int,
    @StringRes val threatsToPenguins: Int,
    @StringRes val breeding: Int,
    @DrawableRes val penguinImage: Int
)
