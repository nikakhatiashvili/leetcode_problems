package org.example.algorithms

fun main(){
    val obj = ZigZagConversation()
    println(obj.convert("PAYPALISHIRING", 4))

}

class ZigZagConversation {
    fun convert(s: String, numRows: Int): String {
        val rows = mutableListOf<MutableList<Char>>()

        val map = mutableMapOf<Int, Int>()
        var crRow = 0
        var downWard = false
        for (i in s.indices){
            map.set(i, crRow)
            if (numRows - 1 == crRow){
                downWard = true
            }
            if (crRow == 0){
                downWard = false
            }
            if (downWard) crRow-- else crRow++
        }

        for(i in s.indices){
            val item = s[i]
            val row = map.getValue(i)

            val list = rows.getOrNull(row)
            if (list == null){
                rows.add(row, mutableListOf(item))
            }else{
                list.add(item)
                rows.set(row, list)
            }
        }
        val str = StringBuilder()
        for (i in rows){
            i.forEach {
                str.append(it.toString())
            }
        }

        return str.toString()
    }
}