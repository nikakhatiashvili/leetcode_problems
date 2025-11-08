package org.example.algorithms

fun main(){
    isAnagram("car", "rat")
}

fun isAnagram(s: String, t: String): Boolean {
    val sArray = s.toCharArray()
    val tArray = t.toCharArray()
    val map = mutableMapOf<Char, Int>()
    val secondMap = mutableMapOf<Char, Int>()

    sArray.forEachIndexed { index, ch ->
        if (map.containsKey(ch)){
            var value = map.getValue(ch)
            map.put(ch, value + 1)
        }else{
            map.put(ch, 1)
        }
        val tChar = tArray.get(index)
        if (secondMap.containsKey(tChar)){
            var value = secondMap.getValue(tChar)
            secondMap.put(tChar, value + 1)
        }else{
            secondMap.put(tChar, 1)
        }
    }
    if (map.size != secondMap.size) return false
    for (i in map){
        val secondValue = secondMap.getOrDefault(i.key, -1)
        if (i.value != secondValue){
            return false
        }
    }

    return true
}