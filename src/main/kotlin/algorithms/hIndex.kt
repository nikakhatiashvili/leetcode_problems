package org.example.algorithms

fun main() {
    val c = hIndex()
    println("expected 1 " + c.hIndex(listOf(0, 0, 2).toIntArray()))
    println("expected 3 " + c.hIndex(listOf(3,0,6,1,5).toIntArray()))
}

class hIndex {
    fun hIndex(citations: IntArray): Int {
        if (citations.isEmpty()) return 0

        val freq = IntArray(1001)

        for (c in citations) {
            freq[c]++
        }
        var papersSoFar = 0

        for (h in 1000 downTo 0) {
            papersSoFar += freq[h]
            if (papersSoFar >= h) {
                return h
            }
        }
        return papersSoFar
    }
}