package org.example.algorithms

fun main(){
    val s = MajoritySolution()
    val arrray = listOf(6,5,5)
    println(s.majorityElementTwo(arrray.toIntArray()))
}

class MajoritySolution {
    fun majorityElement(nums: IntArray): Int {
        if (nums.size < 2) return nums.first()
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices){
            val item = nums[i]

            if (map.containsKey(item)){
                val value = map.getValue(item)
                if (value + 1> nums.size / 2){
                    return item
                }
                map[item] = value + 1
            }else{
                map.set(item, 1)
            }
        }
        return -1
    }

    fun majorityElementTwo(nums: IntArray): Int {
        if (nums.size < 2) return nums.first()
        var majority: Int? = null
        var counter = 1
        for (i in nums.indices){
            val item = nums[i]
            if (majority == null){
                majority = item
            }else{
                if (majority != item){
                    counter--
                }else{
                    counter++
                }
                if (counter < 0){
                    majority = item
                    counter = 1
                }
            }

        }

        return majority ?: 1
    }
}