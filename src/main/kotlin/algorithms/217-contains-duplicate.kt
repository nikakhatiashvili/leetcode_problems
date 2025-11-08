package org.example.algorithms

fun main(){

    val array = IntArray(4)
    array.set(0,1)
    array.set(1,1)
    array.set(2,0)
    array.set(3,8)
    println(containsDuplicate(array))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    for (i in nums){
        if (map.containsKey(i)){
            return true
        }else{
            map.put(i, 0)
        }
    }
    return false
}