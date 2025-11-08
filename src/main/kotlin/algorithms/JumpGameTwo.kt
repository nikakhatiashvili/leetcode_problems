package org.example.algorithms

import kotlin.math.max

fun main() {
    val c = JumpGameTwo()
//    println("expected 2 " + c.canJumpTwo(listOf(1, 2, 3).toIntArray()))
//    println("expected 1 " + c.canJumpTwo(listOf(2, 1).toIntArray()))
    println("expected 2 " + c.canJumpTwo(listOf(2, 3, 1, 1, 4).toIntArray()))
//    println("expected 2 " + c.canJumpTwo(listOf(4, 1, 1, 3, 1, 1, 1).toIntArray()))
//    println("expected 2 " + c.canJumpTwo(listOf(2, 0, 2, 0, 1).toIntArray()))
}

class JumpGameTwo {
    fun canJumpTwo(nums: IntArray): Int {
        var res = 0
        var left = 0
        var right = 0

        while (right < nums.lastIndex){
            var farthest = 0
            for (i in left..right + 1){
                farthest = maxOf(farthest, i + nums[i])
            }
            left = right + 1
            right = farthest
            res++
        }

        return res
    }

    fun canJump(nums: IntArray): Int {
        val lastIndex = nums.lastIndex

        for (i in nums.indices) {
            var item = nums[i]
            if (i + item >= lastIndex) {
                return 1
            }
            var stepsToTake = 0
            var nextIndex = i + item
            while (item > 0) {
                val nextItem = nums[nextIndex]

                if (nextItem <= 0) {
                    item = item - 1
                    nextIndex--
                } else {
                    nextIndex = nextIndex + nextItem
                }
                stepsToTake++
            }
            return stepsToTake
        }
        return -1
    }


}

