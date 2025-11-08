package org.example.better_algorithms.easy

import org.example.better_algorithms.medium.TwoSum

fun main() {
    val twoSum = ValidPalindrome()
    println(twoSum.isPalindrome("0P"))
}

class ValidPalindrome {

    /**
     * my original solution, time complexity of o(n) and space o(n)
     * below is improvement
     */
    fun isPalindrome(s: String): Boolean {

        val validString = StringBuilder()
        for (i in s.indices) {
            val char = s[i]
            if (char.isLetter() || char.isDigit()) {
                validString.append(char.lowercaseChar())
            }
        }
        var left = 0
        var right = validString.lastIndex
        while (left < right) {
            if (validString.get(left) != validString.get(right)) {
                return false
            } else {
                left++
                right--
            }
        }

        println(validString)

        return true
    }

    /**
     * improved space complexity to o(1) from first attempt of o(n)
     */

    fun isPalindromeImprovement() {
        fun isPalindrome(s: String): Boolean {
            var left = 0
            var right = s.lastIndex
            while (left < right) {
                while (left < right && !s[left].isLetterOrDigit()) {
                    left++
                }
                while (left < right && !s[right].isLetterOrDigit()) {
                    right--
                }

                if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                    return false
                }

                left++
                right--
            }

            return true
        }
    }
}