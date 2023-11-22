package com.example.mathgame.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mathgame.Navigation.Screens
import com.example.mathgame.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameScreen(navController: NavController, mode: String) {
    val name = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
            value = name.value,
            placeholder = { Text(text = "Enter username") },
            onValueChange = { name.value = it })
        Button(onClick = {
            navController.navigate(
                route = Screens.Game.getFullRoute(
                    name = name.value, mode = mode
                )
            )
        }) {
            Text(text = "Play")
        }
    }
}