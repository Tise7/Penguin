package com.example.penguin.data

import com.example.penguin.R

data class PenguinSpecies(
    val name: String,
    val imageResId: Int,
    val foodPreferences: Map< FoodItem, Int>,
    var happinessLevel: Int= 0,
    val maxHappiness: Int = 100
)

data class FoodItem(
    val name: String,
    val imageResId: Int,
    val nutritionalValue: Int = 5
)

fun getPenguinSpecies(): List<PenguinSpecies> {
    return listOf(
        emperorPenguin,
        kingPenguin,
        adeliePenguin,
        chinstrapPenguin,
        gentooPenguin,
        macaroniPenguin,
        rockhopperPenguin,
        magellanicPenguin,
        humboldtPenguin,
        littleBluePenguin
    )
}

val emperorPenguin = PenguinSpecies(
    name = "Emperor Penguin",
    imageResId = R.drawable.emperor_penguin,
    foodPreferences = mapOf(
        FoodItem("Squid", R.drawable.squid) to 2,
        FoodItem("Fish", R.drawable.fish) to 2,
        FoodItem("Krill", R.drawable.krill) to 2
    )
)
val kingPenguin = PenguinSpecies(
    name = "King Penguin",
    imageResId = R.drawable.king_penguin,
    foodPreferences = mapOf(
        FoodItem("Fish", R.drawable.fish) to 2,
        FoodItem("Krill", R.drawable.krill) to 1,
        FoodItem("Squid", R.drawable.squid) to 1
    )
)

val adeliePenguin = PenguinSpecies(
    name = "Adélie Penguin",
    imageResId = R.drawable.adelie_penguin,
    foodPreferences = mapOf(
        FoodItem("Krill", R.drawable.krill) to 2,
        FoodItem("Fish", R.drawable.fish) to 1,
        FoodItem("Squid", R.drawable.squid) to 1)
)

val chinstrapPenguin = PenguinSpecies(
    name = "Chinstrap Penguin",
    imageResId = R.drawable.chinstrap_penguin,
    foodPreferences = mapOf(
        FoodItem("Fish", R.drawable.fish) to 1,
        FoodItem("Krill", R.drawable.krill) to 2,
        FoodItem("Squid", R.drawable.squid) to 1
    )
)

val gentooPenguin = PenguinSpecies(
    name = "Gentoo Penguin",
    imageResId = R.drawable.gentoo_penguin,
    foodPreferences = mapOf(
        FoodItem("Krill", R.drawable.krill) to 1,
        FoodItem("Fish", R.drawable.fish) to 2,
        FoodItem("Squid", R.drawable.squid) to 1
    )
)

val macaroniPenguin = PenguinSpecies(
    name = "Macaroni Penguin",
    imageResId= R.drawable.macaroni_penguin,
    foodPreferences = mapOf(
        FoodItem("Squid", R.drawable.squid) to 1,
        FoodItem("Krill", R.drawable.krill) to 2,
        FoodItem("Fish", R.drawable.fish) to 1
    )
)

val rockhopperPenguin = PenguinSpecies(
    name = "Rockhopper Penguin",
    imageResId = R.drawable.rockhopper_penguin,
    foodPreferences = mapOf(
        FoodItem("Krill", R.drawable.krill) to 2,
        FoodItem("Squid", R.drawable.squid) to 2,
        FoodItem("Fish", R.drawable.fish) to 2
    )
)

val magellanicPenguin = PenguinSpecies(
    name = "Magellanic Penguin",
    imageResId = R.drawable.magellanic_penguin,
    foodPreferences = mapOf(
        FoodItem("Squid", R.drawable.squid) to 1,
        FoodItem("Fish", R.drawable.fish) to 2,
        FoodItem("Krill", R.drawable.krill) to 0
    )
)

val humboldtPenguin = PenguinSpecies(
    name = "Humboldt Penguin",
    imageResId = R.drawable.humboldt_penguin,
    foodPreferences = mapOf(
        FoodItem("Fish", R.drawable.fish) to 2,
        FoodItem("Squid", R.drawable.squid) to 1,
        FoodItem("Krill", R.drawable.krill) to 0,
    )
)

val littleBluePenguin = PenguinSpecies(
    name = "Little Blue Penguin",
    imageResId = R.drawable.little_blue_penguin,
    foodPreferences = mapOf(
        FoodItem("Krill", R.drawable.krill) to 0,
        FoodItem("Fish", R.drawable.fish) to 2,
        FoodItem("Squid", R.drawable.squid) to 1,
    )
)