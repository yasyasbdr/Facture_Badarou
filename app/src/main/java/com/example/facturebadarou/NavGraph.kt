package com.example.facturebadarou

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val loginValue = remember { mutableStateOf("") }
            val mdpValue = remember { mutableStateOf("") }
            loginDisplay(navController, loginValue.value, mdpValue.value) { login, mdp ->
                loginValue.value = login
                mdpValue.value = mdp
            }
        }

        composable(
            "accueil/{log1}/{mdp1}",
            arguments = listOf(
                navArgument(name = "log1") {
                    type = NavType.StringType
                },
                navArgument(name = "mdp1") {
                    type = NavType.StringType
                }
            )
        ) { backstaEntry ->
            AccueilDisplay(
                navController,
                login = backstaEntry.arguments?.getString("log1"),
                mdp = backstaEntry.arguments?.getString("mdp1")
            )
        }

        composable("accueil") {
            // Placeholder content for accueil composable
        }
    }

    Button(
        onClick = {
            navController.navigate("accueil/${navController.currentBackStackEntry?.arguments?.getString("log1")}/${navController.currentBackStackEntry?.arguments?.getString("mdp1")}")
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Valider", fontSize = 17.sp)
    }
}
