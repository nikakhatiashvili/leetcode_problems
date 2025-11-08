package org.example.better_algorithms.medium

fun main(){
    val list = listOf(2,7,11,15)
    val target = 9
    val twoSum = TwoSum()
    println(twoSum.twoSum(list.toIntArray(), target).toMutableList().toString())
}

class TwoSum {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val answer = IntArray(2)

        var left = 0
        var right = numbers.lastIndex
        while (left < right){
            val sum = numbers[left] + numbers[right]
            if (sum == target){
                answer.set(0, left + 1)
                answer.set(1, right + 1)
                return answer
            }else if (sum < target){
                left++
            }else{
                right--
            }
        }

        return answer
    }
}