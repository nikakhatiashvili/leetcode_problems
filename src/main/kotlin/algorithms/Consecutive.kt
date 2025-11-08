package org.example.algorithms


fun main() {
    println("answer int " + canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {


    val maxNumber = Int.MIN_VALUE
    var isMinus = false
    val map = listOf<Pair<Int, Int>>()
    for (i in gas.indices) {
        val gasHere = gas[i]
        val gasToGetToNext = cost[i]

        if (gasToGetToNext - gasHere < 0) {

            isMinus = true
        } else {
            isMinus = false

        }
    }


    return -1
}


class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val map = HashMap<Int, Int>()
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        nums.forEach {
            map[it] = it
            if (it < min) {
                min = it
            }
            if (it > max) {
                max = it
            }
        }

        var crCounter = 1
        var maxCounter = 1
        for (i in min..max) {
            if (map.containsKey(i + 1)) {
                crCounter = crCounter + 1
                maxCounter = maxOf(crCounter, maxCounter)
            } else {
                maxCounter = maxOf(crCounter, maxCounter)
                crCounter = 0
            }
        }

        return maxCounter

    }
}


