package com.example.penguin.data

import com.example.penguin.R


object QuestionsDataProvider {

    fun getPenguinQuiz(): List<List<Questions>> {
        return listOf(
            emperorPenguinQuestions,
            kingPenguinQuestions,
            adeliePenguinQuestions,
            chinstrapPenguinQuestions,
            gentooPenguinQuestions,
            macaroniPenguinQuestions,
            rockhopperPenguinQuestions,
            magellanicPenguinQuestions,
            humboldtPenguinQuestions,
            littleBluePenguinQuestions
        )
    }

   private val emperorPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_emperor_1 ,
            options = listOf(
                R.string.option_emperor_1a,
                R.string.option_emperor_1b,
                R.string.option_emperor_1c,
                R.string.option_emperor_1d
            ),
            correctAnswer =  R.string.option_emperor_1b
        ),
        Questions(
            question =  R.string.question_emperor_2,
            options = listOf(
                R.string.option_emperor_2a,
                R.string.option_emperor_2b,
                R.string.option_emperor_2c,
                R.string.option_emperor_2d
            ),
            correctAnswer =  R.string.option_emperor_2b
        ),
       Questions(
           question =  R.string.question_emperor_3,
           options = listOf(
               R.string.option_emperor_3a,
               R.string.option_emperor_3b,
               R.string.option_emperor_3c,
               R.string.option_emperor_3d
           ),
           correctAnswer =  R.string.option_emperor_3c
       ),
       Questions(
           question =  R.string.question_emperor_4,
           options = listOf(
               R.string.option_emperor_4a,
               R.string.option_emperor_4b,
               R.string.option_emperor_4c,
               R.string.option_emperor_4d
           ),
           correctAnswer =  R.string.option_emperor_4c
       ),
       Questions(
           question =  R.string.question_emperor_5,
           options = listOf(
               R.string.option_emperor_5a,
               R.string.option_emperor_5b,
               R.string.option_emperor_5c,
               R.string.option_emperor_5d
           ),
           correctAnswer =  R.string.option_emperor_5b
       )
   )

   private val kingPenguinQuestions = listOf(
       Questions(
           question =  R.string.question_king_1,
           options = listOf(
               R.string.option_king_1a,
               R.string.option_king_1b,
               R.string.option_king_1c,
               R.string.option_king_1d
           ),
           correctAnswer =  R.string.option_king_1b
       ),
       Questions(
           question =  R.string.question_king_2,
           options = listOf(
               R.string.option_king_2a,
               R.string.option_king_2b,
               R.string.option_king_2c,
               R.string.option_king_2d
           ),
           correctAnswer =  R.string.option_king_2a
       ),
       Questions(
           question =  R.string.question_king_3,
           options = listOf(
               R.string.option_king_3a,
               R.string.option_king_3b,
               R.string.option_king_3c,
               R.string.option_king_3d,
               ),
           correctAnswer =  R.string.option_king_3c
       ),
       Questions(
           question =  R.string.question_king_4,
           options = listOf(
               R.string.option_king_4a,
               R.string.option_king_4b,
               R.string.option_king_4c,
               R.string.option_king_4d
               ),
           correctAnswer =  R.string.option_king_4b
       ),
       Questions(
           question =  R.string.question_king_5,
           options = listOf(
               R.string.option_king_5a,
               R.string.option_king_5b,
               R.string.option_king_5c,
               R.string.option_king_5d
               ),
           correctAnswer =  R.string.option_king_5b
       )
   )

    private val adeliePenguinQuestions = listOf(
        Questions(
            question =  R.string.question_adelie_1,
            options = listOf(
                R.string.option_adelie_1a,
                R.string.option_adelie_1b,
                R.string.option_adelie_1c,
                R.string.option_adelie_1d
            ),
            correctAnswer =  R.string.option_adelie_1b
        ),
        Questions(
            question =  R.string.question_adelie_2,
            options = listOf(
                R.string.option_adelie_2a,
                R.string.option_adelie_2b,
                R.string.option_adelie_2c,
                R.string.option_adelie_2d
                ),
            correctAnswer =  R.string.option_adelie_2b
        ),
        Questions(
            question =  R.string.question_adelie_3,
            options = listOf(
                R.string.option_adelie_3a,
                R.string.option_adelie_3b,
                R.string.option_adelie_3c,
                R.string.option_adelie_3d
                ),
            correctAnswer =  R.string.option_adelie_3c
        ),
        Questions(
            question =  R.string.question_adelie_4,
            options = listOf(
                R.string.option_adelie_4a,
                R.string.option_adelie_4b,
                R.string.option_adelie_4c,
                R.string.option_adelie_4d
                ),
            correctAnswer =  R.string.option_adelie_4b
        ),
        Questions(
            question =  R.string.question_adelie_5,
            options = listOf(
                R.string.option_adelie_5a,
                R.string.option_adelie_5b,
                R.string.option_adelie_5c,
                R.string.option_adelie_5d
                ),
            correctAnswer =  R.string.option_adelie_5b
        )
    )

    private val chinstrapPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_chinstrap_1,
            options = listOf(
                R.string.option_chinstrap_1a,
                R.string.option_chinstrap_1b,
                R.string.option_chinstrap_1c,
                R.string.option_chinstrap_1d
                ),
            correctAnswer =  R.string.option_chinstrap_1b
        ),
        Questions(
            question =  R.string.question_chinstrap_2,
            options = listOf(
                R.string.option_chinstrap_2a,
                R.string.option_chinstrap_2b,
                R.string.option_chinstrap_2c,
                R.string.option_chinstrap_2d
                ),
            correctAnswer =  R.string.option_chinstrap_2b
        ),
        Questions(
            question =  R.string.question_chinstrap_3,
            options = listOf(
                R.string.option_chinstrap_3a,
                R.string.option_chinstrap_3b,
                R.string.option_chinstrap_3c,
                R.string.option_chinstrap_3d
                ),
            correctAnswer =  R.string.option_chinstrap_3b
        ),
        Questions(
            question =  R.string.question_chinstrap_4,
            options = listOf(
                R.string.option_chinstrap_4a,
                R.string.option_chinstrap_4b,
                R.string.option_chinstrap_4c,
                R.string.option_chinstrap_4d
                ),
            correctAnswer =  R.string.option_chinstrap_4b
        ),
        Questions(
            question =  R.string.question_chinstrap_5,
            options = listOf(
                R.string.option_chinstrap_5a,
                R.string.option_chinstrap_5b,
                R.string.option_chinstrap_5c,
                R.string.option_chinstrap_5d
                ),
            correctAnswer =  R.string.option_chinstrap_5a
        )
    )

    private val gentooPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_gentoo_1,
            options = listOf(
                R.string.option_gentoo_1a,
                R.string.option_gentoo_1b,
                R.string.option_gentoo_1c,
                R.string.option_gentoo_1d
                ),
            correctAnswer =  R.string.option_gentoo_1c
        ),
        Questions(
            question =  R.string.question_gentoo_2,
            options = listOf(
                R.string.option_gentoo_2a,
                R.string.option_gentoo_2b,
                R.string.option_gentoo_2c,
                R.string.option_gentoo_2d
                ),
            correctAnswer =  R.string.option_gentoo_2a
        ),
        Questions(
            question =  R.string.question_gentoo_3,
            options = listOf(
                R.string.option_gentoo_3a,
                R.string.option_gentoo_3b,
                R.string.option_gentoo_3c,
                R.string.option_gentoo_3d
                ),
            correctAnswer =  R.string.option_gentoo_3b
        ),
        Questions(
            question =  R.string.question_gentoo_4,
            options = listOf(
                R.string.option_gentoo_4a,
                R.string.option_gentoo_4b,
                R.string.option_gentoo_4c,
                R.string.option_gentoo_4d
                ),
            correctAnswer =  R.string.option_gentoo_4c
        ),
        Questions(
            question =  R.string.question_gentoo_5,
            options = listOf(
                R.string.option_gentoo_5a,
                R.string.option_gentoo_5b,
                R.string.option_gentoo_5c,
                R.string.option_gentoo_5d
                ),
            correctAnswer =  R.string.option_gentoo_5b
        )
    )

    private val macaroniPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_macaroni_1,
            options = listOf(
                R.string.option_macaroni_1a,
                R.string.option_macaroni_1b,
                R.string.option_macaroni_1c,
                R.string.option_macaroni_1d
                ),
            correctAnswer =  R.string.option_macaroni_1a
        ),
        Questions(
            question =  R.string.question_macaroni_2,
            options = listOf(
                R.string.option_macaroni_2a,
                R.string.option_macaroni_2b,
                R.string.option_macaroni_2c,
                R.string.option_macaroni_2d
                ),
            correctAnswer =  R.string.option_macaroni_2a
        ),
        Questions(
            question = R.string.question_macaroni_3,
            options = listOf(
                R.string.option_macaroni_3a,
                R.string.option_macaroni_3b,
                R.string.option_macaroni_3c,
                R.string.option_macaroni_3d
                ),
            correctAnswer =  R.string.option_macaroni_3b
        ),
        Questions(
            question =  R.string.question_macaroni_4,
            options = listOf(
                R.string.option_macaroni_4a,
                R.string.option_macaroni_4b,
                R.string.option_macaroni_4c,
                R.string.option_macaroni_4d
                ),
            correctAnswer =  R.string.option_macaroni_4b
        ),
        Questions(
            question =  R.string.question_macaroni_5,
            options = listOf(
                R.string.option_macaroni_5a,
                R.string.option_macaroni_5b,
                R.string.option_macaroni_5c,
                R.string.option_macaroni_5d
                ),
            correctAnswer =  R.string.option_macaroni_5a
        )
    )

    private val rockhopperPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_rockhopper_1,
            options = listOf(
                R.string.option_rockhopper_1a,
                R.string.option_rockhopper_1b,
                R.string.option_rockhopper_1c,
                R.string.option_rockhopper_1d
                ),
            correctAnswer =  R.string.option_rockhopper_1a
        ),
        Questions(
            question =  R.string.question_rockhopper_2,
            options = listOf(
                R.string.option_rockhopper_2a,
                R.string.option_rockhopper_2b,
                R.string.option_rockhopper_2c,
                R.string.option_rockhopper_2d
                ),
            correctAnswer =  R.string.option_rockhopper_2b
        ),
        Questions(
            question =  R.string.question_rockhopper_3,
            options = listOf(
                R.string.option_rockhopper_3a,
                R.string.option_rockhopper_3b,
                R.string.option_rockhopper_3c,
                R.string.option_rockhopper_3d
                ),
            correctAnswer =  R.string.option_rockhopper_3b
        ),
        Questions(
            question =  R.string.question_rockhopper_4,
            options = listOf(
                R.string.option_rockhopper_4a,
                R.string.option_rockhopper_4b,
                R.string.option_rockhopper_4c,
                R.string.option_rockhopper_4d
                ),
            correctAnswer =  R.string.option_rockhopper_4b
        ),
        Questions(
            question =  R.string.question_rockhopper_5,
            options = listOf(
                R.string.option_rockhopper_5a,
                R.string.option_rockhopper_5b,
                R.string.option_rockhopper_5c,
                R.string.option_rockhopper_5d
                ),
            correctAnswer =  R.string.option_rockhopper_5a
        )
    )

    private val magellanicPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_magellanic_1,
            options = listOf(
                R.string.option_magellanic_1a,
                R.string.option_magellanic_1b,
                R.string.option_magellanic_1c,
                R.string.option_magellanic_1d
                ),
            correctAnswer =  R.string.option_magellanic_1a
        ),
        Questions(
            question =  R.string.question_magellanic_2,
            options = listOf(
                R.string.option_magellanic_2a,
                R.string.option_magellanic_2b,
                R.string.option_magellanic_2c,
                R.string.option_magellanic_2d
                ),
            correctAnswer =  R.string.option_magellanic_2a
        ),
        Questions(
            question =  R.string.question_magellanic_3,
            options = listOf(
                R.string.option_magellanic_3a,
                R.string.option_magellanic_3b,
                R.string.option_magellanic_3c,
                R.string.option_magellanic_3d
                ),
            correctAnswer =  R.string.option_magellanic_3a
        ),
        Questions(
            question =  R.string.question_magellanic_4,
            options = listOf(
                R.string.option_magellanic_4a,
                R.string.option_magellanic_4b,
                R.string.option_magellanic_4c,
                R.string.option_magellanic_4d
                ),
            correctAnswer =  R.string.option_magellanic_4b
        ),
        Questions(
            question =  R.string.question_magellanic_5,
            options = listOf(
                R.string.option_magellanic_5a,
                R.string.option_magellanic_5b,
                R.string.option_magellanic_5c,
                R.string.option_magellanic_5d
                ),
            correctAnswer =  R.string.option_magellanic_5a
        )
    )

    private val humboldtPenguinQuestions = listOf(
        Questions(
            question =  R.string.question_humboldt_1,
            options = listOf(
                R.string.option_humboldt_1a,
                R.string.option_humboldt_1b,
                R.string.option_humboldt_1c,
                R.string.option_humboldt_1d
                ),
            correctAnswer =  R.string.option_humboldt_1a
        ),
        Questions(
            question =  R.string.question_humboldt_2,
            options = listOf(
                R.string.option_humboldt_2a,
                R.string.option_humboldt_2b,
                R.string.option_humboldt_2c,
                R.string.option_humboldt_2d
                ),
            correctAnswer =  R.string.option_humboldt_2a
        ),
        Questions(
            question =  R.string.question_humboldt_3,
            options = listOf(
                R.string.option_humboldt_3a,
                R.string.option_humboldt_3b,
                R.string.option_humboldt_3c,
                R.string.option_humboldt_3d,
                ),
            correctAnswer =  R.string.option_humboldt_3a
        ),
        Questions(
            question = R.string.question_humboldt_4,
            options = listOf(
                R.string.option_humboldt_4a,
                R.string.option_humboldt_4b,
                R.string.option_humboldt_4c,
                R.string.option_humboldt_4d
                ),
            correctAnswer =  R.string.option_humboldt_4a
        ),
        Questions(
            question =  R.string.question_humboldt_5,
            options = listOf(
                R.string.option_humboldt_5a,
                R.string.option_humboldt_5b,
                R.string.option_humboldt_5c,
                R.string.option_humboldt_5d
            ),
            correctAnswer =  R.string.option_humboldt_5a
        )
    )

    private val littleBluePenguinQuestions = listOf(
        Questions(
            question =  R.string.question_little_blue_1,
            options = listOf(
                R.string.option_little_blue_1a,
                R.string.option_little_blue_1b,
                R.string.option_little_blue_1c,
                R.string.option_little_blue_1d,
            ),
            correctAnswer =  R.string.option_little_blue_1a
        ),
        Questions(
            question = R.string.question_little_blue_2,
            options = listOf(
                R.string.option_little_blue_2a,
                R.string.option_little_blue_2b,
                R.string.option_little_blue_2c,
                R.string.option_little_blue_2d,
            ),
            correctAnswer =  R.string.option_little_blue_2a
        ),
        Questions(
            question =  R.string.question_little_blue_3,
            options = listOf(
                R.string.option_little_blue_3a,
                R.string.option_little_blue_3b,
                R.string.option_little_blue_3c,
                R.string.option_little_blue_3d,
            ),
            correctAnswer =  R.string.option_little_blue_3a
        ),
        Questions(
            question =  R.string.question_little_blue_4,
            options = listOf(
                R.string.option_little_blue_4a,
                R.string.option_little_blue_4b,
                R.string.option_little_blue_4c,
                R.string.option_little_blue_4d,
            ),
            correctAnswer =  R.string.option_little_blue_4b
        ),
        Questions(
            question =  R.string.question_little_blue_5,
            options = listOf(
                R.string.option_little_blue_5a,
                R.string.option_little_blue_5b,
                R.string.option_little_blue_5c,
                R.string.option_little_blue_5d,
                ),
            correctAnswer =  R.string.option_little_blue_5a
        )
    )

}