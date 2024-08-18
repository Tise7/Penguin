package com.example.penguin.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.penguin.R
import com.example.penguin.data.Penguin

@Composable
fun PenguinImage(
    penguinImage: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier){
        Image(
            painter = painterResource(id = penguinImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()

        )
    }
}

@Composable
fun PenguinName(
    penguinName: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = penguinName),
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier.fillMaxWidth()
    )
}


@Composable
fun PenguinCard (
    imageResourceId: Int,
    textResourceId: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = onItemClick
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            PenguinImage(
                penguinImage = imageResourceId,
                modifier = modifier
                    .weight(.8f)
            )
            Text(
                text = textResourceId,
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.fillMaxWidth()
                        .padding(vertical = 36.dp, horizontal = 26.dp)
                        .weight(2.5f)
            )
        }
    }
}


@Composable
fun TopicRowSpacer(visible: Boolean) {
    AnimatedVisibility(visible = visible) {
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun TopicRow(
    penguin: Penguin,
    topic: String,
    expanded: Boolean,
    onClick: () -> Unit
) {
    TopicRowSpacer(visible = expanded)
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = 2.dp,
        color = MaterialTheme.colorScheme.surfaceDim,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = topic,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = when (topic) {
                        "Description" -> stringResource(id = penguin.description)
                        "Lifestyle and Habitat" -> stringResource(id = penguin.lifestyleAndHabitat)
                        "Diet" -> stringResource(id = penguin.diet)
                        "Size and Weight" -> stringResource(id = penguin.sizeAndWeight)
                        "Relationships" -> stringResource(id = penguin.relationships)
                        "History and Lifespan" -> stringResource(id = penguin.historyAndLifespan)
                        "Breeding" -> stringResource(id = penguin.breeding)
                        "Threats To Penguins" -> stringResource(id = penguin.threatsToPenguins)
                        else -> ""
                    },
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
    TopicRowSpacer(visible = expanded)
}