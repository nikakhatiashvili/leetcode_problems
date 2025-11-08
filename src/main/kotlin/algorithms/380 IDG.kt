package org.example.algorithms

fun main() {
    val randomizedSet = Solution2()
    randomizedSet.productExceptSelf(listOf(1,2,3,4).toIntArray())
    randomizedSet.productExceptSelf(listOf(-1,1,0,-3,3).toIntArray())
}


class Solution2 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val prefix = IntArray(n)
        val postfix = IntArray(n)
        val result = IntArray(n)

        prefix[0] = nums[0]
        for (i in 1 until n) {
            prefix[i] = prefix[i - 1] * nums[i]
        }

        postfix[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0) {
            postfix[i] = postfix[i + 1] * nums[i]
        }

        for (i in 0 until n) {
            val left = if (i > 0) prefix[i - 1] else 1
            val right = if (i < n - 1) postfix[i + 1] else 1
            result[i] = left * right
        }
        return result
    }

}
