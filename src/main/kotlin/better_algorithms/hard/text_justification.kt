package org.example.better_algorithms.hard

import kotlin.math.max
import kotlin.math.min


/**
 * 68: Text Justification
 *
 * მოცემული გაქვს სიტყვების სია და მაქსიმალური სიგანე
 * უნდა გააერთიანო სიტყვები ისე რომ არ თითოელი ხაზის სიგრძე არ იყოს მაქსიმალურ სიგანეზე დიდი
 *
 * 0: თითო ხაზი უნდა იყოს ზუსტად იმ სიგანის რაც არის მაქსიმალური სიგანე
 *
 * 1: ისეთ დროს როდესაც მეტ სიტყვას ვერ ამატებ თითო ხაზში დარჩენილი ადგილი შეავსე ცარიელი სტრინგით “ “
 *
 * 2: როდესაც გიწევს რომ სივრცე შეავსო ცარიელი სტრინგებით უნდა შეეცადო რომ მაქსიმალურად თანაბრად დაყო ეს ცარიელი სტრინგები,
 * იმ შემთხვევაში თუ თანაბრად არ იყოფა მაშინ მარცხენა მხარეს  უნდა მოხდეს პრიორიტეტი და იყოს უფრო მეტი ცარიელი სტრინგი
 *
 * 3: ბოლო ხაზი უნდა იყოს მარცხნივ  გამართული რაც ნიშნავს რომ თუ 2 სიტყვა გვაქ ბოლო ხაზში მაშინ ცარიელი სტრინგები უნდა დავამატოთ ყოველთვის მარჯვენა მხარეს იმის მაგივრად რომ თანაბრად გავანაწილოთ
 *
 * 4: ყველა სიტყვის შორის უნდა იყოს 1 ცარიელი სტრინგის დაშორება
 *
 */
fun main() {
    val list = listOf("This", "is", "an", "example", "of", "text", "justification.")
    val taget = 16
    val obj = textJustification()
    println(obj.fullJustify(list.toTypedArray(), taget))
    testCases()
}

fun testCases(){
    val list = listOf("What","must","be","acknowledgment","shall","be")
    val list2 = listOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do")
    val taget = 16
    val taget2 = 20
    val obj = textJustification()
    println(obj.fullJustify(list.toTypedArray(), taget))
    println(obj.fullJustify(list2.toTypedArray(), taget2))
}

class textJustification {

    /**
     *    this is my first submission that worked
     */
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {

        val lines = mutableListOf<Pair<MutableList<String>, Int>>()

        var line = StringBuilder()
        val list = mutableListOf<String>()
        var length = 0
        for (i in words.indices) {
            val item = words[i]
            if (line.isEmpty()) {
                line.append(item)
                list.add(item.toString())
                length += item.length
            } else {
                // maxWidth 14
                // line.Length = 4
                // next word = 2 to add it we need at least 3 space 2 + 1
                // we can do this: 14-4 >= (2 + 1)
                // 1 here is extra space we need between words
                if (maxWidth - line.length >= (item.length + 1)) {
                    // we can add the text here
                    line.append(" ".plus(item))
                    length += item.length
                    list.add(item.toString())
                } else {
                    // we can no longer add any text to this line
                    lines.add(Pair(list.toMutableList(), length))
                    length = 0
                    line.clear()
                    list.clear()
                    line.append(item)
                    list.add(item)
                    length += item.length
                }
            }
        }
        lines.add(Pair(list.toMutableList(), length))

        val output = mutableListOf<String>()
        val linesOfTexts = StringBuilder()

        for (i in lines.indices) {
            val crList = lines[i]
            if (lines.lastIndex == i){
                for (i in crList.first.indices){
                    if (i == 0){
                        linesOfTexts.append(crList.first[i])
                    }else{
                        linesOfTexts.append(" ".plus(crList.first[i]))
                    }
                }
                linesOfTexts.append(" ".repeat(maxWidth -linesOfTexts.length))
            }else{
                if (crList.first.size == 1) {
                    linesOfTexts.append(crList.first.first().plus(" ".repeat(maxWidth - crList.first.first().length)))
                }
                if (crList.first.size == 2) {
                    val first = crList.first.first()
                    val second = crList.first[1]
                    linesOfTexts.append(
                        first.plus(
                            " ".repeat(maxWidth - (first.length + second.length))
                        ).plus(second),
                    )
                }
                if (crList.first.size > 2){
                    // length of all words is 8
                    // that means we need to subtract 8 from maxWidth which in this case is 16
                    // we then divide that to get the amount of  strings we need to put after each text
                    // (maxWidth - length) / (size - 1)
                    val remaining = maxWidth - crList.second
                    val dividers = crList.first.size - 1
                    val minStrDivider = (remaining / dividers).toInt()
                    var leftOver = remaining % dividers
                    for (i in crList.first.indices){
                        val crItem = crList.first[i]
                        val repeatAmount = if (leftOver > 0) {
                            (minStrDivider + 1).also { leftOver-- }
                        } else minStrDivider

                        if (i == crList.first.lastIndex){
                            linesOfTexts.append(crItem)
                        }else{
                            linesOfTexts.append(crItem.plus(" ".repeat(repeatAmount)))
                        }
                    }
                }
            }

            output.add(linesOfTexts.toString())
            linesOfTexts.clear()
        }

        return output
    }

    /**
     *    simplifying my original answer
     */

    fun fullJustifySimplified(words: Array<String>, maxWidth: Int): List<String> {
        val lines = mutableListOf<Pair<List<String>, Int>>()
        var currentWords = mutableListOf<String>()
        var currentLength = 0

        for (word in words) {
            val extraSpace = if (currentWords.isEmpty()) 0 else 1
            if (currentLength + word.length + extraSpace <= maxWidth) {
                currentWords.add(word)
                currentLength += word.length + extraSpace
            } else {
                lines.add(currentWords.toList() to currentWords.sumOf { it.length })
                currentWords = mutableListOf(word)
                currentLength = word.length
            }
        }
        if (currentWords.isNotEmpty()) {
            lines.add(currentWords.toList() to currentWords.sumOf { it.length })
        }

        val output = mutableListOf<String>()

        for ((index, linePair) in lines.withIndex()) {
            val (words, totalWordLength) = linePair

            val isLastLine = index == lines.lastIndex
            val line = when {
                isLastLine -> {
                    val joined = words.joinToString(" ")
                    joined + " ".repeat(maxWidth - joined.length)
                }

                words.size == 1 -> {
                    words.first().padEnd(maxWidth, ' ')
                }

                else -> {
                    val remaining = maxWidth - totalWordLength
                    val dividers = words.size - 1
                    val baseSpaces = remaining / dividers
                    var extraSpaces = remaining % dividers

                    buildString {
                        for ((i, word) in words.withIndex()) {
                            append(word)
                            if (i < dividers) {
                                val spaceCount = baseSpaces + if (extraSpaces-- > 0) 1 else 0
                                append(" ".repeat(spaceCount))
                            }
                        }
                    }
                }
            }

            output.add(line)
        }

        return output
    }

}


















