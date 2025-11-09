package org.example.better_algorithms.medium

import kotlin.math.min

fun main() {
    val list = listOf(2, 3, 1, 2, 4, 3)
    val list4 = listOf(1,2,3,4,5)
    val list3 = listOf(1,1,1,1,1,1,1,1)
    val list2 = listOf(1,4,4)
    val list5 = listOf(5,1,3,5,10,7,4,9,2,8)
    val obj = minimumSubArray()
    println(obj.minSubArrayLen(7, list.toIntArray()))
    println(obj.minSubArrayLen(4, list2.toIntArray()))
    println(obj.minSubArrayLen(11, list3.toIntArray()))
    println(obj.minSubArrayLen(11, list4.toIntArray()))
    println(obj.minSubArrayLen(15, list5.toIntArray()))
}


class minimumSubArray {


    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var finalAnswer = Int.MAX_VALUE
        var currentSubSize = 0
        var startIndex = 0
        var sum = 0
        for (i in nums.indices) {
            val number = nums[i]
            if (number >= target) return 1
            sum += number
            while (sum >= target && sum - nums[startIndex] >= target){
                sum -= nums[startIndex]
                startIndex++
                currentSubSize--
            }
            currentSubSize++
            if (sum >= target) {
                finalAnswer = minOf(currentSubSize, finalAnswer)
            }
        }

        return if (sum < target) 0 else finalAnswer
    }
}