package org.example.algorithms

import kotlin.math.max

fun main(){
    val c = MaxProfit()
    println(c.maxProfitTwo(listOf(7,6,4,3,1).toIntArray()))
}

class MaxProfit {
    fun maxProfitTwo(prices: IntArray): Int {

        var maxProfit = 0
        var highestNum: Int? = null
        for (i in prices.indices.reversed()){
            val item = prices[i]
            if (highestNum == null){
                highestNum = item
            }else{
                if (item >= highestNum){
                    highestNum = item
                }else{
                    maxProfit += highestNum - item
                    highestNum = item
                }
            }
        }
        return maxProfit
    }

    fun maxProfit(prices: IntArray): Int {

        var maxProfit = 0
        var highestNum: Int? = null
        for (i in prices.indices.reversed()){
            val item = prices[i]
            if (highestNum == null){
                highestNum = item
            }else{
                if (item >= highestNum){
                    highestNum = item
                }else{
                    maxProfit = maxOf(maxProfit,  highestNum - item)
                }
            }
        }
        return maxProfit
    }
}