package com.example.facturebadarou

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun loginDisplay(navController: NavHostController) {
    val modifier = Modifier
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var loginValue by remember {
            mutableStateOf("")
        }
        var mdpValue by remember {
            mutableStateOf("")
        }

        Text(text = "Authentification", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Red)
        Spacer(
            modifier = modifier
                .height(75.dp)
                .fillMaxSize()
        )

        Text(text = "Votre login", fontSize = 15.sp)
        TextField(
            value = loginValue,
            onValueChange = { loginValue = it },
            modifier = modifier.padding(5.dp),
            placeholder = {
                Text("Login ...")
            }
        )
        Spacer(modifier = modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("accueil")
        }) {
            Text(text = "Valider", fontSize = 17.sp)
        }
    }
}
