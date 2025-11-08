package org.example.algorithms

fun main() {
    val trap1 = listOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1) // 6

    val trap2 = listOf(4, 2, 0, 3, 2, 5) // 9

    val obj = RomanSolution()
//    println(obj.romanToInt("III"))
//    println(obj.romanToInt("LVIII"))
//    println(obj.romanToInt("MCMXCIV"))
    println(obj.intToRoman(3749))
    println(obj.intToRoman(58))
    println(obj.intToRoman(1994))

}

class RomanSolution {

    fun intToRoman(num: Int): String {

        val str = num.toString()
        val array = str.toCharArray()
        val answer = StringBuilder()
        val maps = mapOf<Int, String>(
            0 to "IVX",
            1 to "XLC",
            2 to "CDM",
            3 to "M",
        )
        var unit = 0
        for (i in array.indices.reversed()){
            val char = maps.getValue(unit)
            val itme = array[i].toString().toInt()
            if (itme == 4){
                answer.insert(0,char.substring(0,2))
            }else if (itme == 9){
                answer.insert(0,"${char.first()}${char.last()}")
            }else if (itme > 0){
                if (itme >= 5){
                    val leftOver = array[i].toString().toInt() - 5
                    if (leftOver > 0){
                        for (i in 1..leftOver){
                            answer.insert(0,char.first())
                        }
                    }
                    answer.insert(0,char.get(1))
                }else{
                    val leftOver = array[i].toString().toInt()
                    if (leftOver > 0){
                        for (i in 1..leftOver){
                            answer.insert(0,char.first())
                        }
                    }
                }
            }
            unit++
        }

        return answer.toString()
    }


    fun romanToInt(s: String): Int {
        val mapToValue = mapOf<Char, Int>(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

        var sum = 0
        var lastValue = 'O'
        val charArray = s.toCharArray()
        for (i in charArray.indices.reversed()){
            val current = charArray[i]
            if (current == 'I' && ( lastValue == 'V' || lastValue == 'X')){
                sum -= 1
            }else if (current == 'X' &&( lastValue == 'L' || lastValue == 'C')) {
                sum -= 10
            }else if (current == 'C' && (lastValue == 'D' || lastValue == 'M')) {
                sum -= 100
            }else{
                sum += mapToValue.getValue(current)
            }

            lastValue = charArray[i]
        }

        return sum
    }
}