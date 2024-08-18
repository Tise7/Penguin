package com.example.penguin.data

import com.example.penguin.R

object PenguinDataProvider {

    fun getPenguinData(): List<Penguin> {
        return listOf(
            penguin_1,
            penguin_2,
            penguin_3,
            penguin_4,
            penguin_5,
            penguin_6,
            penguin_7,
            penguin_8,
            penguin_9,
            penguin_10
        )
    }

    private val penguin_1 = Penguin(
        id = 1,
        penguinName =  R.string.penguin_1_name,
        description =  R.string.penguin_1_description,
        lifestyleAndHabitat = R.string.penguin_1_lifestyle_and_hab1itat,
        diet = R.string.penguin_1_diet,
        sizeAndWeight = R.string.penguin_1_size_and_weight,
        relationships = R.string.penguin_1_relationships,
        historyAndLifespan = R.string.penguin_1_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_1,
        breeding = R.string.penguin_1_Breeding,
        penguinImage = R.drawable.emperor_penguin,

    )
    private val penguin_2 = Penguin(
        id = 2,
        penguinName =  R.string.penguin_2_name,
        description = R.string.penguin_2_description,
        lifestyleAndHabitat = R.string.penguin_2_lifestyle_and_hab1itat,
        diet = R.string.penguin_2_diet,
        sizeAndWeight = R.string.penguin_2_size_and_weight,
        relationships = R.string.penguin_2_relationships,
        historyAndLifespan = R.string.penguin_2_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_2,
        breeding = R.string.penguin_2_Breeding,
        penguinImage = R.drawable.king_penguin
    )
    private val penguin_3 = Penguin(
        id = 3,
        penguinName =  R.string.penguin_3_name,
        description = R.string.penguin_3_description,
        lifestyleAndHabitat = R.string.penguin_3_lifestyle_and_habitat,
        diet = R.string.penguin_3_diet,
        sizeAndWeight = R.string.penguin_3_size_and_weight,
        relationships = R.string.penguin_3_relationships,
        historyAndLifespan = R.string.penguin_3_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_3,
        breeding = R.string.penguin_3_Breeding,
        penguinImage = R.drawable.adelie_penguin
    )
    private val penguin_4 = Penguin(
        id = 4,
        penguinName =  R.string.penguin_4_name,
        description = R.string.penguin_4_description,
        lifestyleAndHabitat = R.string.penguin_4_lifestyle_and_habitat,
        diet = R.string.penguin_4_diet,
        sizeAndWeight = R.string.penguin_4_size_and_weight,
        relationships = R.string.penguin_4_relationships,
        historyAndLifespan = R.string.penguin_4_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_4,
        breeding = R.string.penguin_4_Breeding,
        penguinImage = R.drawable.chinstrap_penguin
    )
    private val penguin_5 = Penguin(
        id = 5,
        penguinName =  R.string.penguin_5_name,
        description = R.string.penguin_5_description,
        lifestyleAndHabitat = R.string.penguin_5_lifestyle_and_habitat,
        diet = R.string.penguin_5_diet,
        sizeAndWeight = R.string.penguin_5_size_and_weight,
        relationships = R.string.penguin_5_relationships,
        historyAndLifespan = R.string.penguin_5_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_5,
        breeding = R.string.penguin_5_Breeding,
        penguinImage = R.drawable.gentoo_penguin
    )
    private val penguin_6 = Penguin(
        id = 6,
        penguinName =  R.string.penguin_6_name,
        description = R.string.penguin_6_description,
        lifestyleAndHabitat = R.string.penguin_6_lifestyle_and_habitat,
        diet = R.string.penguin_6_diet,
        sizeAndWeight = R.string.penguin_6_size_and_weight,
        relationships = R.string.penguin_6_relationships,
        historyAndLifespan = R.string.penguin_6_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_6,
        breeding = R.string.penguin_6_Breeding,
        penguinImage = R.drawable.macaroni_penguin
    )
    private val penguin_7 = Penguin(
        id = 7,
        penguinName =  R.string.penguin_7_name,
        description = R.string.penguin_7_description,
        lifestyleAndHabitat = R.string.penguin_7_lifestyle_and_habitat,
        diet = R.string.penguin_7_diet,
        sizeAndWeight = R.string.penguin_7_size_and_weight,
        relationships = R.string.penguin_7_relationships,
        historyAndLifespan = R.string.penguin_7_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_7,
        breeding = R.string.penguin_7_Breeding,
        penguinImage = R.drawable.rockhopper_penguin
    )
    private val penguin_8 = Penguin(
        id = 8,
        penguinName =  R.string.penguin_8_name,
        description = R.string.penguin_8_description,
        lifestyleAndHabitat = R.string.penguin_8_lifestyle_and_habitat,
        diet = R.string.penguin_8_diet,
        sizeAndWeight = R.string.penguin_8_size_and_weight,
        relationships = R.string.penguin_8_relationships,
        historyAndLifespan = R.string.penguin_8_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_8,
        breeding = R.string.penguin_8_Breeding,
        penguinImage = R.drawable.magellanic_penguin
    )
    private val penguin_9 = Penguin(
        id = 9,
        penguinName =  R.string.penguin_9_name,
        description = R.string.penguin_9_description,
        lifestyleAndHabitat = R.string.penguin_9_lifestyle_and_habitat,
        diet = R.string.penguin_9_diet,
        sizeAndWeight = R.string.penguin_9_size_and_weight,
        relationships = R.string.penguin_9_relationships,
        historyAndLifespan = R.string.penguin_9_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_9,
        breeding = R.string.penguin_9_Breeding,
        penguinImage = R.drawable.humboldt_penguin
    )
    private val penguin_10 = Penguin(
        id = 10,
        penguinName =  R.string.penguin_10_name,
        description = R.string.penguin_10_description,
        lifestyleAndHabitat = R.string.penguin_10_lifestyle_and_habitat,
        diet = R.string.penguin_10_diet,
        sizeAndWeight = R.string.penguin_10_size_and_weight,
        relationships = R.string.penguin_10_relationships,
        historyAndLifespan = R.string.penguin_10_history_and_lifespan,
        threatsToPenguins = R.string.threats_to_penguin_10,
        breeding = R.string.penguin_10_Breeding,
        penguinImage = R.drawable.little_blue_penguin
    )

}