package com.example.penguin.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.penguin.R
import com.example.penguin.utils.PenguinScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreTopAppBar(
    modifier: Modifier = Modifier,
    titleResourceId: Int? = null,
    defaultTitle: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            if (titleResourceId != null) {
                Text(
                    text = stringResource(titleResourceId),
                    style = MaterialTheme.typography.headlineSmall
                )
            } else {
                Text(
                    text = defaultTitle,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


@Composable
fun ExploreBottomAppBar(
    currentScreen: PenguinScreens,
    onHomeClick: () -> Unit,
    onQuizClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_home),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.inverseSurface,
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = MaterialTheme.colorScheme.inversePrimary,
            ),
            onClick = onHomeClick,
            selected = currentScreen == PenguinScreens.PenguinList
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.quiz),
                    contentDescription = null
                )

            },
            label = {
                Text(
                    text = stringResource(R.string.Quiz),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.inverseSurface,
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = MaterialTheme.colorScheme.inversePrimary,
            ),
            selected = currentScreen == PenguinScreens.Quiz,
            onClick = onQuizClick
        )
    }
}