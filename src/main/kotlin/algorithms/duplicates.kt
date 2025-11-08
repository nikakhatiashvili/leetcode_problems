package org.example.algorithms

fun main(){
    val s = SSolution()
    val arrray = listOf(0,0,0,0,1,1,1,1,2,3,3,3)
    println(s.removeDuplicates(arrray.toIntArray()))
}

class SSolution {
    fun removeDuplicates(nums: IntArray): Int {

        var last: Int? = null
        var counter = 1
        var moveLeftCounter = 0
        for (i in nums.indices){
            val item = nums[i]
            nums.set(i - moveLeftCounter, item)
            if (last == item){
                if (counter >= 2){
                    moveLeftCounter++
                    nums.set(i, -100)
                }else{
                    counter++
                }
            }else{
                last = item
                counter = 1
            }
        }

        println(nums.toList().toString())

        return nums.size - moveLeftCounter
    }
}