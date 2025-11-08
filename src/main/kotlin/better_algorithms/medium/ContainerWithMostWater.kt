package org.example.better_algorithms.medium

import kotlin.math.max
import kotlin.math.min


/**
 * 11: Container with most water
 *
 * მოცემული გაქვს ინტეჯერების სია, თითოეული ინტეჯერი განსაზღვრავს კედლის სიმაღლეს 2D სივრცეში
 *
 * პასუხი: უნდა იპოვო ის მარცხენა და მარჯვენა კედლები რომლებიც
 * შეძლებენ ყველაზე მეტი წყლის დატევას
 *
 * წყლის დატევა გულისხმობს მარცხენა და მარჯვენა
 * კედლებს შორის  პატარას აღებს და გამრავლება იმდენზე რამდენი
 * ელემენტიც აშორებს ამ მარცხენა და მარჯვენას ერთმანეთთან + 1
 *
 */
fun main() {
    val list = listOf(1,8,6,2,5,4,8,3,7)
    val obj = ContainerWithMostWater()
    println(obj.maxArea(list.toIntArray()))
}

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {

        var left = 0
        var right = height.lastIndex
        var maxArea = 0
        while (left < right){
            val minimum = min(height[left], height[right])
            val area = minimum * (right - left)
            maxArea = max(area, maxArea)
            if (height[left] <= height[right]){
                left++
            }else{
                right--
            }
        }

        return maxArea
    }
}