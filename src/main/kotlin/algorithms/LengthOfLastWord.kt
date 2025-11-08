package org.example.algorithms


fun main() {
    val obj = LengthOfLastWord()
    println(obj.lengthOfLastWord("hello world")) // 5
    println(obj.lengthOfLastWord("   fly me   to   the moon  ")) // 4
    println(obj.lengthOfLastWord("luffy is still joyboy")) // 6

}


class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {

        var length = 0
        for (i in s.reversed()){
            if (i == ' '){
                if (length > 0){
                    return length
                }
            }else{
                length++
            }
        }
        return length
    }
}