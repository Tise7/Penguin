package com.example.penguin.ui.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.penguin.R
import com.example.penguin.data.PenguinSpecies
import com.example.penguin.ui.viewmodel.PenguinGameViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun GameApp() {
    val navController = rememberNavController()
    val viewModel = viewModel<PenguinGameViewModel>()

    NavHost(
        navController = navController,
        startDestination = "main_menu"
    ) {
        composable("main_menu") {
            MainMenuScreen(
                viewModel = viewModel,
                onNavigateToGame = { penguin ->
                    viewModel.selectPenguin(penguin)
                    navController.navigate("game_screen/${penguin.name}")
                }
            )
        }
        composable("game_screen/{penguinName}") {
            val penguin = viewModel.uiState.value.selectedPenguin
            if (penguin != null) {
                FeedingGameScreen(
                    penguin = penguin,
                    viewModel = viewModel,
                    onQuitButtonClicked = { navController.navigate("main_menu") },
                )

            }
        }
    }
}


@Composable
fun MainMenuScreen(
    viewModel: PenguinGameViewModel,
    onNavigateToGame: (PenguinSpecies) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.card_corner_radius)),
        contentPadding = PaddingValues(20.dp)

    ) {
        items(uiState.penguinSpecies) { penguin ->
            PenguinCard(
                imageResourceId = penguin.imageResId,
                textResourceId = penguin.name,
                onItemClick = { onNavigateToGame(penguin)}
            )
        }
    }
}


@Composable
fun FeedingGameScreen(
    penguin: PenguinSpecies,
    onQuitButtonClicked: () -> Unit,
    viewModel: PenguinGameViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Box {
        if (uiState.showClickEffect) {
            EmojiAnimation()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = penguin.name,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.secondary,
            )

            Spacer(modifier = Modifier.height(26.dp))

            Image(
                painter = painterResource(id = penguin.imageResId),
                contentDescription = penguin.name,
                modifier = Modifier.size(400.dp)
            )

            Spacer(modifier = Modifier.height(26.dp))

            LinearProgressIndicator(
                progress = { uiState.currentHappiness.toFloat() / penguin.maxHappiness.toFloat() },
                modifier = Modifier.fillMaxWidth(.8f),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                penguin.foodPreferences.keys.forEach { foodItem ->
                    Card(
                        elevation = CardDefaults.cardElevation(5.dp),
                        shape = androidx.compose.foundation.shape.CircleShape,
                        modifier = Modifier.padding(8.dp),
                        onClick = { viewModel.feedPenguin(foodItem)}
                    ) {
                        Image(
                            painter = painterResource(id = foodItem.imageResId),
                            contentDescription = foodItem.name,
                            modifier = Modifier
                                .size(60.dp)
                        )
                    }
                }
            }
            if (uiState.finalDialogShow) {
                FinalDialog(
                    onPlayAgainButtonClicked = {
                        viewModel.resetGame()
                        viewModel.selectPenguin(penguin)
                    },
                    onQuitButtonClicked = {
                        viewModel.resetGame()
                        onQuitButtonClicked()
                    }
                )
            }
        }
    }
}


@Composable
fun FinalDialog(
    onPlayAgainButtonClicked: () -> Unit,
    onQuitButtonClicked: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(
                text = "Congratulations!"
            )
        },
        text = {
            Text(
                text = "You fed the penguin to its heart's content! Play again or go back to the menu."
            )
        },
        confirmButton = {
            Button(onClick = onPlayAgainButtonClicked) {
                Text("Play Again")
            }
        },
        dismissButton = {
            Button(
                onClick = onQuitButtonClicked

            ) {
                Text("Back to Menu")
            }
        }
    )
}

@Composable
fun EmojiAnimation() {
    val density = LocalDensity.current

    for (i in 0..75) {
        val offsetX by animateFloatAsState(
            targetValue = with(density) { ((-100)..500).random().toDp().toPx() },
            animationSpec = tween(durationMillis = 4000),
            label = ""
        )
        val offsetY by animateFloatAsState(
            targetValue = with(density) { ((-300)..700).random().toDp().toPx() },
            animationSpec = tween(durationMillis = 4000),
            label = ""
        )
        val alpha by animateFloatAsState(
            targetValue = .1f + (Math.random() * .9f).toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 500),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
        Text(
            text = "💖",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .offset(x = offsetX.dp, y = offsetY.dp)
                .alpha(alpha)
        )
    }
}
