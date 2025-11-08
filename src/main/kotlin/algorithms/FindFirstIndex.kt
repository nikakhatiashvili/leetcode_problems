package org.example.algorithms

fun main() {
    val obj = FindFirstIndex()
    println(obj.strStr("mississippi", "issipi"))
    println(obj.strStr("mississippi", "issip"))
    println(obj.strStr("aaa", "aaaa"))
    println(obj.strStr("sadbutsad", "sad"))
    println(obj.strStr("leetcode", "leeto"))
}

class FindFirstIndex {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.length > haystack.length) return -1

        for (i in  haystack.indices){

        }


        return -1
    }
}