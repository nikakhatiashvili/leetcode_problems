package org.example.better_algorithms.medium


/**
 * 15: 3Sum
 *
 *
 *  მოცემული გაქ ინტეჯერების სია
 *  დააბრუნე მასივების მასივი ისე რომ თითოეული მასივის ელემენტების ჯამი იყოს 0
 *
 *  ისე რომ სამივე ელემენტის ინდექსი იყოს განსხვავებული
 *  და ისე რომ არ მეორდებოდეს 3-ე ელემენტი
 *
 *  ავიღებთ პირველ ელემენტს და მივუმატებთ 0-ს
 *  შემდეგ ავდგებით და შევეცდებით ვიპოვოთ 2 რიცხვი რომელიც ერთად არის  ის რაც რო მივუმატოთ  ამ მიღებულ ციფრს მივიღებთ 0-ს
 *
 */

fun main() {
    val list = listOf(-1, 0, 1, 2, -1, -4)
    val obj = `3Sum`()
    println(obj.threeSum(list.toIntArray()))
}


class `3Sum` {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            var left = i + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[left] + nums[right]
                if (sum == 0 - nums[i]) {
                    set.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                } else if (sum < 0 - nums[i]) {
                    left++
                } else {
                    right--
                }
            }
        }

        return set.toList()
    }

    fun threeSumSimplified(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var left = i + 1
            var right = nums.lastIndex
            val target = -nums[i]

            while (left < right) {
                val sum = nums[left] + nums[right]

                when {
                    sum == target -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        left++
                        right--
                    }
                    sum < target -> left++
                    else -> right--
                }
            }
        }

        return result
    }
}