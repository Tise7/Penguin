package com.example.penguin.utils

import androidx.annotation.StringRes
import com.example.penguin.R


enum class PenguinScreens (@StringRes val title: Int) {
    Welcome(title = R.string.welcome),
    PenguinList(title = R.string.Penguins),
    PenguinDetail(title = R.string.Penguin_Detail),
    Quiz(title = R.string.Quiz),
    PenguinGame(title = R.string.Penguin_Catch)

}