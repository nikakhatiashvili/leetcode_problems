package org.example.better_algorithms.easy


fun main() {
    val isSubsequence = IsSubsequence()
    println(isSubsequence.isSubsequence("b", "abc"))
    println(isSubsequence.isSubsequence("abc", "ahbgdc"))
    println(isSubsequence.isSubsequence("axc", "ahbgdc"))
    println(isSubsequence.isSubsequence("bb", "ahbgbdc"))
}

class IsSubsequence {

    /**
     * my original solution
     */

    fun isSubsequence(s: String, t: String): Boolean {
        var left = 0
        var leftIndex = 0
        while (leftIndex <= t.lastIndex) {
            if (t[leftIndex] == s[left]) {
                left++
            }
            leftIndex++
            if (left == s.length) {
                return true
            }
        }
        return false
    }


    fun isSubsequencePolished(s: String, t: String): Boolean {
        var sIndex = 0

        for (char in t) {
            if (sIndex < s.length && char == s[sIndex]) {
                sIndex++
            }
        }

        return sIndex == s.length
    }
}


