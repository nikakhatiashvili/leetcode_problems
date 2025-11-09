package org.example.better_algorithms.medium

fun main() {
    val obj = LongestUniqueSubstring()
    println(obj.lengthOfLongestSubstring("abcabcbb")) // correct = 3
    println(obj.lengthOfLongestSubstring("bbbbb")) // correct = 1
    println(obj.lengthOfLongestSubstring("pwwkew")) // correct = 3
}

class LongestUniqueSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val window = mutableSetOf<Char>()
        var left = 0
        var maxLength = 0
        for (i in s.indices) {
            while (window.contains(s[i])) {
                window.remove(s[left])
                left++
            }
            window.add(s[i])
            maxLength = maxOf(window.size, maxLength)
        }

        return maxLength
    }
}