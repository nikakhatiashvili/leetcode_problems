package org.example.algorithms

fun main() {
    val c = JumpGame()
    println(c.canJump(listOf(1,1,2,2,0,1,1).toIntArray()))
    println(c.canJump(listOf(2,3,1,1,4).toIntArray()))
    println(c.canJump(listOf(3,2,1,0,4).toIntArray()))
    println(c.canJump(listOf(3, 0, 8, 2, 0, 0, 1).toIntArray()))
    println(c.canJump(listOf(5,9,3,2,1,0,2,3,3,1,0,0).toIntArray()))
    println(c.canJump(listOf(5,9,3,2,1,0,2,3,3,1,0,0).toIntArray()))
}

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        //watched explanation after spending 1 and a half hour
        var goalPost = nums.lastIndex
        for (i in nums.size - 1 downTo 0) {
            if (i + nums[i] >= goalPost) goalPost = i
        }
        return goalPost == 0
    }
}