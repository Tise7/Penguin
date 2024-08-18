package com.example.penguin.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.penguin.R
import com.example.penguin.ui.viewmodel.FeedThePenguinViewModel


@Composable
fun FeedThePenguinScreen(
    viewModel: FeedThePenguinViewModel = FeedThePenguinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(2.5f)
            ) {
                val currentStep = uiState.currentStep
                AnimatedVisibility(
                    visible = currentStep > 0,
                    enter = fadeIn(animationSpec = tween(durationMillis = 1000)) +
                            scaleIn(animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )),
                    exit = fadeOut(animationSpec = tween(durationMillis = 1000))
                ) {
                    PenguinTextAndImage(
                        textLabelResourceId = when (currentStep) {
                            1 -> R.string.sad_penguin
                            2 -> R.string.more_please
                            3 -> R.string.keep_feeding_the_penguin
                            4 -> R.string.happy_penguin
                            else -> R.string.sad_penguin
                        },
                        drawableResourceId = when (currentStep) {
                            1 -> R.drawable.penguin_1
                            2 -> R.drawable.penguin_2
                            3 -> R.drawable.penguin_3
                            4 -> R.drawable.penguin_4
                            else -> R.drawable.penguin_1
                        },
                        onImageClick = { viewModel.onImageClick() },
                        showClickEffect = uiState.showClickEffect,
                        isLastImage = currentStep == 4
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = { viewModel.resetGame() },
                    enabled = uiState.currentStep == 4
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Retry",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun PenguinTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    onImageClick: () -> Unit,
    showClickEffect: Boolean,
    isLastImage: Boolean,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                onClick = onImageClick,
                elevation = CardDefaults.cardElevation( defaultElevation = 100.dp),
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius))
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        if (isLastImage && showClickEffect) {
            Box(modifier = Modifier.fillMaxSize()) {
                for (i in 0..45) {
                    val offsetX by animateFloatAsState(
                        targetValue = with(density) { ((-200)..700).random().toDp().toPx() },
                        animationSpec = tween(durationMillis = 9000),
                        label = ""
                    )
                    val offsetY by animateFloatAsState(
                        targetValue = with(density) { ((-200)..700).random().toDp().toPx() },
                        animationSpec = tween(durationMillis = 9000),
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
        }
    }
}