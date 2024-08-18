package com.example.penguin.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.penguin.R
import com.example.penguin.data.Questions
import com.example.penguin.ui.viewmodel.QuizUiState
import com.example.penguin.ui.viewmodel.QuizViewModel


@Composable
fun QuizApp() {
    val navController = rememberNavController()
    val viewModel: QuizViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = "penguin_selection"
    ) {
        composable("penguin_selection") {
            PenguinSelectionScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable("quiz_screen") {
            QuizScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}


@Composable
fun PenguinSelectionScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: QuizViewModel = viewModel()
) {
    val penguinTypes = listOf(
        R.string.penguin_1_name,
        R.string.penguin_2_name,
        R.string.penguin_3_name,
        R.string.penguin_4_name,
        R.string.penguin_5_name,
        R.string.penguin_6_name,
        R.string.penguin_7_name,
        R.string.penguin_8_name,
        R.string.penguin_9_name,
        R.string.penguin_10_name
    )
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)
    ) {
        items(penguinTypes.size) { index ->
            Card(
                onClick = {
                    viewModel.loadQuestions(index)
                    navController.navigate("quiz_screen")
                },
                elevation = CardDefaults.cardElevation(),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(dimensionResource(R.dimen.card_image_height))
                ) {
                    PenguinImage(
                        penguinImage = when (index) {
                            0 -> R.drawable.emperor_penguin
                            1 -> R.drawable.king_penguin
                            2 -> R.drawable.adelie_penguin
                            3 -> R.drawable.chinstrap_penguin
                            4 -> R.drawable.gentoo_penguin
                            5 -> R.drawable.macaroni_penguin
                            6 -> R.drawable.rockhopper_penguin
                            7 -> R.drawable.magellanic_penguin
                            8 -> R.drawable.humboldt_penguin
                            9 -> R.drawable.little_blue_penguin
                            else -> R.drawable.emperor_penguin
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(.8f)
                    )
                    PenguinName(
                        penguinName = penguinTypes[index],
                        modifier = Modifier
                            .padding(vertical = 16.dp, horizontal = 16.dp)
                            .weight(2.5f)
                            .align(Alignment.Top)
                    )
                }
            }
        }
    }
}


@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()
    val currentQuestion = uiState.currentQuestions

    if (uiState.showResult) {
        ResultDialog(
            score = uiState.score,
            totalQuestions = uiState.questions.size,
            onRetryClick = { viewModel.onRetryButtonClicked() }
        )
    } else if (currentQuestion != null) {
        QuestionContent(
            currentQuestions = currentQuestion,
            uiState = uiState,
            onOptionSelected = { index -> viewModel.onOptionSelected(index) },
            onPreviousButtonClicked = { viewModel.onPreviousButtonClicked() },
            onNextButtonClicked = { viewModel.onNextButtonClicked() },
            onSubmitButtonClicked = { viewModel.onSubmitButtonClicked() },
            onQuitButtonClicked = { navController.navigate("penguin_selection") }
        )
    }
}


@Composable
fun QuestionContent(
    modifier: Modifier = Modifier,
    currentQuestions: Questions,
    uiState: QuizUiState,
    onOptionSelected: (Int) -> Unit,
    onPreviousButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSubmitButtonClicked: () -> Unit,
    onQuitButtonClicked: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)
    ) {
        // Progress indicator
        LinearProgressIndicator(
                progress = {
                   if (uiState.questions.isNotEmpty()) {
                        (uiState.questions.indexOf(currentQuestions) + 1).toFloat() / uiState.questions.size
                    } else {
                        0f
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )

        // Question text
        Text(
            text = stringResource(id = currentQuestions.question),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(
                horizontal = 16.dp,vertical = 16.dp
            )
        )

        // Options
        currentQuestions.options.forEachIndexed { index, option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = uiState.selectedOptionIndex == index,
                    onClick = { onOptionSelected(index) }
                )
                Text(text = stringResource(id = option))
            }
        }

        // Navigation buttons
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            // Previous button
            OutlinedButton(
                onClick = onPreviousButtonClicked,
                enabled = uiState.currentQuestionIndex > 0,
                modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.previous),
                style = MaterialTheme.typography.titleMedium
            )
        }
            Spacer(modifier = Modifier.weight(1f))

            // Next/Submit button
            val isLastQuestion = uiState.currentQuestionIndex == uiState.questions.size - 1
            OutlinedButton(
                onClick = {
                    if (isLastQuestion) {
                        onSubmitButtonClicked()
                    } else {
                        onNextButtonClicked()
                    }
                },
                enabled = uiState.selectedOptionIndex != null,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = if (isLastQuestion) stringResource(id = R.string.submit)
                    else stringResource(id = R.string.next),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        FilledTonalButton(
            onClick = onQuitButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 40.dp)

        ) {
            Text(
                text = stringResource(id = R.string.quit),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun ResultDialog(
    score: Int,
    totalQuestions: Int,
    onRetryClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(
                text = stringResource(id = R.string.result),
                style = MaterialTheme.typography.titleMedium
            )
        },
        text= {
            Text(
                text = "Your score: $score out of $totalQuestions",
                style = MaterialTheme.typography.bodyLarge
            )
        },
        confirmButton = {
            Button(onClick = onRetryClick) {
                Text(
                    text = stringResource(id = R.string.retry),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    )
}