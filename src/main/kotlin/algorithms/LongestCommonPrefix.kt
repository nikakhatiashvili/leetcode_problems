package org.example.algorithms

fun main() {
    val obj = LongestCommonPrefix()
    println(obj.longestCommonPrefix(
        listOf("aaa","aa","aaa")
            .toList().toTypedArray())) // fl

}


class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val answer = StringBuilder()
        answer.append(strs.first())

        for (i in 1..strs.size - 1){
            if (answer.toString().isEmpty()){
                return ""
            }
            var current = strs[i]
            if (current == answer.toString()){

            }else{
                val minof = minOf(current.length, answer.length)
                for (s in 0..minof -1){
                    if (current[s].toString() != answer[s].toString()){
                        answer.setLength(s)
                        break
                    }
                }
                if (answer.length > current.length) {
                    answer.setLength(current.length)
                }
            }
        }


        return answer.toString()
    }
}