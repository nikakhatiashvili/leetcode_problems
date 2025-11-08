package org.example.algorithms

fun main(){
    val obj = ReverseWords()
    println(obj.reverseWords("a good   example"))
    println(obj.reverseWords("the sky is blue"))
    println(obj.reverseWords("   hello world    "))

}


class ReverseWords {
    fun reverseWords(s: String): String {

        val answer = StringBuilder()
        val lastWord = StringBuilder()
        for (i in s.indices.reversed()){
            val item = s[i].toString()
            if (item == " "){
                if (lastWord.isNotEmpty()){
                    answer.append(if (answer.isEmpty()) lastWord else " $lastWord")
                    lastWord.setLength(0)
                }
            }else{
                lastWord.insert(0,item)
            }
        }
        if (lastWord.length > 0){
            answer.append(if (answer.isEmpty()) lastWord else " $lastWord")
        }
        return answer.toString()
    }
}