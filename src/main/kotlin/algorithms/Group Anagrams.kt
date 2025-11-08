package org.example.algorithms

fun main() {
    val case1 = arrayOf("eat","tea","tan","ate","nat","bat")

    println(groupAnagrams(case1))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<Char, Int>()
    val listofStrs = mutableListOf<List<String>>()
    val checkedIndexes = mutableListOf<Int>()
    for (i in strs.indices) {
        val anagramsHere = mutableListOf<String>()
        if (checkedIndexes.contains(i)) {
            continue
        }
        val item = strs[i]
        anagramsHere.add(item)

        for (i in item) {
            if (map.containsKey(i)) {
                val value = map.getValue(i)
                map.set(i, value + 1)
            } else {
                map.put(i, 1)
            }
        }
        val startinIndex = i + 1
        if (startinIndex <= strs.lastIndex) {
            for (j in startinIndex..strs.lastIndex) {

                val nextItem = strs[j]

                println(nextItem)
                if (item.length != nextItem.length || checkedIndexes.contains(j)) {

                } else {
                    val tempItem = mutableMapOf<Char, Int>()
                    map.forEach {
                        tempItem.put(it.key, it.value)
                    }
                    for (i in nextItem) {
                        if (tempItem.containsKey(i)) {
                            val value = tempItem.getValue(i)
                            tempItem.set(i, value - 1)
                        } else {

                        }
                    }
                    var isAllZero = true
                    tempItem.forEach {
                        if (it.value != 0) {
                            isAllZero = false
                        }
                    }
                    if (isAllZero) {
                        checkedIndexes.add(j)
                        anagramsHere.add(nextItem)
                    }
                }
            }
        }
        map.clear()
        listofStrs.add(anagramsHere)
    }
    return listofStrs
}