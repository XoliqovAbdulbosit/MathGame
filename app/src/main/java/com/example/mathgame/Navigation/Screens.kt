package com.example.mathgame.Navigation

const val MODE_KEY = "mode_key"
const val SCORE_KEY = "score_key"
const val TASKS_KEY = "tasks_key"
const val NAME_KEY = "name_key"

sealed class Screens(val route: String) {
    object Splash : Screens("Splash")
    object Home : Screens("Home")

    object Name : Screens("Name/{$MODE_KEY}") {
        fun getFullRoute(mode: String): String {
            return "Name/$mode"
        }
    }

    object Game : Screens("Game/{$MODE_KEY}/{$NAME_KEY}") {
        fun getFullRoute(mode: String, name: String): String {
            return "Game/$mode/$name"
        }
    }

    object Result : Screens("Result/{$SCORE_KEY}/{$TASKS_KEY}/{$MODE_KEY}") {
        fun getFullRoute(score: Int, tasks: Int, mode: String): String {
            return "Result/$score/$tasks/$mode"
        }
    }
}