package com.example.penguin.ui.screen

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.example.penguin.R
import com.example.penguin.data.Penguin

@Composable
fun PenguinDetail(
    selectedPenguin: Penguin,
    modifier: Modifier = Modifier,
) {

    val allTopics = stringArrayResource(R.array.topics).toList()
    var expandedTopic by rememberSaveable { mutableStateOf<String?>(null) }


    var expanded by remember{ mutableStateOf(false) }
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState, label = "expand")

    val cardOffset by transition.animateDp(
        transitionSpec = {
            if (targetState) {
                // Expanding
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            } else {
                // Collapsing
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            }
        },
        label = "cardHeight"
    ) { if (it) 0.dp - 0.dp else -(0.dp - 520.dp)}

    Box(modifier = modifier){
        Column {
            Box(modifier = modifier) {
                PenguinImage(
                    penguinImage = selectedPenguin.penguinImage,
                    modifier = modifier
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = cardOffset)
                ) {
                    Card(
                        elevation = CardDefaults.cardElevation(),
                        shape = RoundedCornerShape(topStart = 68.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceDim
                        ),
                        modifier = modifier
                            .height(980.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = modifier
                                    .clickable {
                                        expanded = !expanded
                                        transitionState.targetState = !expanded
                                    }
                            ) {
                                PenguinName(
                                    penguinName = selectedPenguin.penguinName,
                                    modifier = modifier
                                        .padding(
                                            horizontal = 30.dp, vertical = 22.dp
                                        )
                                )
                            }
                            LazyColumn {
                                items(allTopics) { topic ->
                                    TopicRow(
                                        penguin = selectedPenguin,
                                        topic = topic,
                                        expanded = expandedTopic == topic,
                                        onClick = {
                                            expandedTopic =
                                                if (expandedTopic == topic) null else topic
                                        },
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}