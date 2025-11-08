package org.example.algorithms

fun main(){
    val s = RotateArray()
    val arrray = listOf(1,2,3,4,5,6,7)
    s.rotate(arrray.toIntArray(),3)
    s.rotateTwo(arrray.toIntArray(),3)
}


class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        val hashMap = mutableMapOf<Int, Int>()
        for (i in nums.indices){
            val newIndex = (i + k) % nums.size
            hashMap.set(newIndex, value = nums[i])
        }
        hashMap.forEach { (key, value) ->
            nums.set(key, value)
        }
        println(nums.toList())

    }

    fun rotateTwo(nums: IntArray, k: Int): Unit {
        val k = k % nums.size
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp

            left++
            right--
        }

        var leftOne = 0
        var rightOne = k - 1

        while (leftOne < rightOne) {
            val temp = nums[leftOne]
            nums[leftOne] = nums[rightOne]
            nums[rightOne] = temp

            leftOne++
            rightOne--
        }

        var leftTwo = k
        var rightTwo = nums.size - 1

        while (leftTwo < rightTwo) {
            val temp = nums[leftTwo]
            nums[leftTwo] = nums[rightTwo]
            nums[rightTwo] = temp

            leftTwo++
            rightTwo--
        }

    }
}