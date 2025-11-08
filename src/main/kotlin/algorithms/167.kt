package org.example.algorithms

fun main(){
    val obj = Obj()
    obj.twoSum(listOf(2,7,11,15).toIntArray(), target = 9)
}
class Obj {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in numbers.indices){
            val item = numbers[i]
            val searchKey = target - item
            var search = true
            var endListPosition = i
            var startListPosition = numbers.lastIndex
            while (search){
                if (startListPosition == endListPosition){
                    search = false
                }
            }
        }
        return IntArray(-1,)
    }
}