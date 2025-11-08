package org.example.algorithms

import kotlin.math.min

fun main() {
    val failed = listOf(1, 3, 2, 2, 1) // 7
    val ratings = listOf(10, 20, 30, 30, 20, 10) // 1,2,3,3,2,1  // 12
    val ratings2 = listOf(1, 0, 2) // 5
    val ratings3 = listOf(1, 2, 2) // 4
    val obj = Candy()
    println(obj.candy(failed.toIntArray()))
    println(obj.candy(ratings.toIntArray()))
    println(obj.candy(ratings2.toIntArray()))
    println(obj.candy(ratings3.toIntArray()))
}

class Candy {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val candies = IntArray(n) { 1 }

        // left to right
        for (i in 1 until n) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
        }

        // right to left
        for (i in n - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = maxOf(candies[i], candies[i + 1] + 1)
            }
        }

        return candies.sum()
    }
}