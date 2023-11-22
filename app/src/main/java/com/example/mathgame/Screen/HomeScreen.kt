package com.example.mathgame.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mathgame.Model.SharedPreference
import com.example.mathgame.Navigation.Screens
import com.example.mathgame.R

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val easy = SharedPreference(context).getRecords(SharedPreference.RecordType.EASY)
    val medium = SharedPreference(context).getRecords(SharedPreference.RecordType.MEDIUM)
    val hard = SharedPreference(context).getRecords(SharedPreference.RecordType.HARD)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Select Mode",
                fontSize = 27.sp,
                color = Color.White,
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 125.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                onClick = {
                    navController.navigate(
                        route = Screens.Name.getFullRoute(mode = "easy")
                    )
                }) {
                Text(text = "Easy")
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 125.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                onClick = {
                    navController.navigate(
                        route = Screens.Name.getFullRoute(mode = "medium")
                    )
                }) {
                Text(text = "Medium")
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 125.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                onClick = {
                    navController.navigate(
                        route = Screens.Name.getFullRoute(mode = "hard")
                    )
                }) {
                Text(text = "Hard")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (easy.isNotEmpty()) {
                val user = easy.sortedWith(compareBy({ it.second }, { it.first })).asReversed()[0]
                Text(
                    text = "Easy Mode: ${user.first}",
                    fontSize = 18.sp,
                    color = Color.White,
                )
                Text(
                    text = "Score: ${user.second}",
                    fontSize = 17.sp,
                    color = Color.White,
                )
            }
            if (medium.isNotEmpty()) {
                val user = medium.sortedWith(compareBy({ it.second }, { it.first })).asReversed()[0]
                Text(
                    text = "Medium Mode: ${user.first}",
                    fontSize = 18.sp,
                    color = Color.White,
                )
                Text(
                    text = "Score: ${user.second}",
                    fontSize = 17.sp,
                    color = Color.White,
                )
            }
            if (hard.isNotEmpty()) {
                val user = hard.sortedWith(compareBy({ it.second }, { it.first })).asReversed()[0]
                Text(
                    text = "Hard Mode: ${user.first}",
                    fontSize = 18.sp,
                    color = Color.White,
                )
                Text(
                    text = "Score: ${user.second}",
                    fontSize = 17.sp,
                    color = Color.White,
                )
            }
        }
    }
}