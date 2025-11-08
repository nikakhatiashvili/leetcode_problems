package org.example.algorithms

fun main(){
    val gas = listOf(5,1,2,3,4)
    val cost = listOf(4,4,1,5,1)
    val obj = GasStation()
    println(obj.gasStation(gas.toIntArray(), cost.toIntArray()))
}

class GasStation {
    fun gasStation(gas: IntArray, cost: IntArray): Int {
        var startingIndex = -1
        var leftOverGas = 0
        var gasFromStartPoint = 0
        for (i in gas.indices){
            val gasHere = gas[i]
            val costToNext = cost[i]

            leftOverGas += gasHere
            leftOverGas -= costToNext
            if (startingIndex != -1){
                gasFromStartPoint += gasHere
                gasFromStartPoint -= costToNext
            }
            if (gasHere >= costToNext && startingIndex == -1){
                startingIndex = i
                gasFromStartPoint = 0
                gasFromStartPoint += gasHere
                gasFromStartPoint -= costToNext
            }

            if (costToNext > gasHere && gasFromStartPoint < 0){
                startingIndex = -1
            }
        }
        if (leftOverGas < 0){
            return -1
        }else {
            return startingIndex
        }
    }
}