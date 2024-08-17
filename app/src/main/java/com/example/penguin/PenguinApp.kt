package com.example.penguin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.penguin.ui.screen.ExploreBottomAppBar
import com.example.penguin.ui.screen.ExploreTopAppBar
import com.example.penguin.ui.screen.FeedThePenguinScreen
import com.example.penguin.ui.screen.PenguinDetail
import com.example.penguin.ui.screen.PenguinList
import com.example.penguin.ui.screen.QuizApp
import com.example.penguin.ui.screen.WelcomeScreen
import com.example.penguin.ui.viewmodel.PenguinViewModel
import com.example.penguin.utils.PenguinScreens

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PenguinApp(
    modifier: Modifier = Modifier,
    viewModel: PenguinViewModel = PenguinViewModel(),
    navController: NavHostController = rememberNavController(),
) {
    val uiState by viewModel.uiState.collectAsState()

//    val selectedPenguinTitleResourceId = uiState.currentPenguin?.penguinName

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route?.let { route ->
        // Extract screen name from route (before '/')
        val screenName = route.substringBefore('/')
        try {
            PenguinScreens.valueOf(screenName)
        } catch (e: IllegalArgumentException) {
            null // Handle cases where screen name doesn't match any enum value
        }
    } ?: PenguinScreens.Welcome

    Scaffold(
        topBar = {
            if (currentScreen != PenguinScreens.Welcome) {
                when (currentScreen) {
                    PenguinScreens.PenguinList -> {
                        ExploreTopAppBar(
                            defaultTitle = stringResource(R.string.Penguins),
                            canNavigateBack = navController.previousBackStackEntry != null,
                            navigateUp = { navController.navigateUp() }
                        )
                    }
                    PenguinScreens.PenguinDetail -> {
                        ExploreTopAppBar(
                            defaultTitle = "",
                            canNavigateBack = navController.previousBackStackEntry != null,
                            navigateUp = { navController.navigateUp() }
                        )

                    }
                    PenguinScreens.Quiz -> {
                        ExploreTopAppBar(
                            defaultTitle = stringResource(R.string.TestYourPenguinKnowledge),
                            canNavigateBack = false,
                            navigateUp = { }
                        )
                    }
                    PenguinScreens.PenguinGame -> {
                        ExploreTopAppBar(
                            defaultTitle = stringResource(R.string.feed_the_penguin),
                            canNavigateBack = false,
                            navigateUp = { }
                        )
                    }
                    else -> {
                    }
                }
            }
        },
        bottomBar = {
            if (currentScreen != PenguinScreens.Welcome) {
                ExploreBottomAppBar(
                    currentScreen = currentScreen,
                    onHomeClick = {
                        navController.navigate(PenguinScreens.PenguinList.name) {
                            popUpTo(PenguinScreens.PenguinList.name) { inclusive = true }
                        }
                    },
                    onQuizClick = {
                        navController.navigate(PenguinScreens.Quiz.name){
                            popUpTo(PenguinScreens.Quiz.name) { inclusive = true }
                        }
                    },
                    onGameClick = {
                        navController.navigate(PenguinScreens.PenguinGame.name){
                            popUpTo(PenguinScreens.PenguinGame.name) { inclusive = true }
                        }
                    }
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PenguinScreens.Welcome.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            composable(route = PenguinScreens.Welcome.name) {
                WelcomeScreen(
                    onNavigateToMenuList = {
                        navController.navigate(PenguinScreens.PenguinList.name)
                    }
                )
            }
            composable(route = PenguinScreens.PenguinList.name) {
                PenguinList(
                    penguin = uiState.penguinList,
                    onItemClick = { penguin ->
                        navController.navigate("${PenguinScreens.PenguinDetail.name}/${penguin.id}")
                    }
                )
            }
            composable(
                route = "${PenguinScreens.PenguinDetail.name}/{penguinId}",
                arguments = listOf(navArgument("penguinId") { type = NavType.IntType })
            ) { backStackEntry ->
                val penguinId = backStackEntry.arguments?.getInt("penguinId") ?: 0
                val currentPenguin = viewModel.uiState.value.penguinList.find { it.id == penguinId }
                if (currentPenguin != null) {
                    PenguinDetail(selectedPenguin = currentPenguin)
                } else {
                    Text("No penguin found")
                }
            }
            composable(route = PenguinScreens.Quiz.name) {
                QuizApp()
            }
            composable(route = PenguinScreens.PenguinGame.name) {
                FeedThePenguinScreen()
            }
        }
    }
}