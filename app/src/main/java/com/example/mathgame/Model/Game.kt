package com.example.mathgame.Model

class Game {
    fun getRandom(mode: String): Pair<String, String> {
        var first = 0
        var second = 0
        when (mode) {
            "easy" -> {
                first = (1..10).random()
                second = (1..10).random()
            }

            "medium" -> {
                first = (1..50).random()
                second = (1..50).random()
            }

            "hard" -> {
                first = (1..100).random()
                second = (1..100).random()
            }
        }
        val operators = listOf("*", "/", "+", "-")
        val operator = operators.random()
        if (operator == "/") {
            while (first % second != 0) {
                when (mode) {
                    "easy" -> {
                        first = (1..10).random()
                        second = (1..10).random()
                    }

                    "medium" -> {
                        first = (1..50).random()
                        second = (1..50).random()
                    }

                    "hard" -> {
                        first = (1..100).random()
                        second = (1..100).random()
                    }
                }
            }
        }
        return Pair("$first _ $second = ${solve(first, second, operator)}", operator)
    }

    private fun solve(first: Int, second: Int, operator: String): String {
        return when (operator) {
            "*" -> "${first * second}"
            "/" -> "${first / second}"
            "+" -> "${first + second}"
            "-" -> "${first - second}"
            else -> {
                "Error"
            }
        }
    }
}