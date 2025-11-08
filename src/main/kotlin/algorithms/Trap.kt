package org.example.algorithms

import java.util.Stack
import kotlin.math.min

fun main() {
    val trap1 = listOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1) // 6

    val trap2 = listOf(4, 2, 0, 3, 2, 5) // 9

    val obj = TrapWater()
    println(obj.trap(trap1.toIntArray()))
    println(obj.trap(trap2.toIntArray()))
}

class TrapWater {
    fun trap(height: IntArray): Int {

        var ans = 0
        var current = 0
        val st = Stack<Int>()

        while (current < height.size) {
            while (st.isNotEmpty() && height[current] > height[st.peek()]) {
                val top = st.pop()
                if (st.isEmpty()) break
                val distance = current - st.peek() - 1
                val boundedHeight = minOf(height[current], height[st.peek()]) - height[top]
                ans += distance * boundedHeight
            }
            st.push(current++)
        }
        return ans
    }
}