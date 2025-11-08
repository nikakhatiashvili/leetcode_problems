package org.example.google

fun main(){
    val emails = listOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    val obj = EmailsSent()
    obj.numUniqueEmailsTraversal(emails.toTypedArray())
}

class EmailsSent {
    fun numUniqueEmails(emails: Array<String>): Int {
        val set = mutableSetOf<String>()

        for (i in emails.indices){
            val string = emails[i]
            val uniqueStr = StringBuilder()
            var inLocalName = true
            var inDomainName = false
            var skipChars = false
            for (i in string.indices){
                val char = string[i]
                if (char == '@'){
                    inLocalName = false
                    inDomainName = true
                    skipChars = false
                    uniqueStr.append(char)
                    continue
                }
                if (skipChars && inLocalName){
                    continue
                }
                if (char == '+' && inLocalName){
                    skipChars = true
                    continue
                }
                if (char != '.' && inLocalName){
                    uniqueStr.append(char)
                }
                if (inDomainName){
                    uniqueStr.append(char)
                }
            }
            set.add(uniqueStr.toString())
        }
        return set.size
    }

    fun numUniqueEmailsTraversal(emails: Array<String>): Int {
        val set = mutableSetOf<String>()

        for (i in emails.indices){
            val string = emails[i]
            val uniqueStr = StringBuilder()

            val domainStr = StringBuilder()
            var domainIndex = 0
            for (i in string.indices.reversed()){
                val char = string[i]
                if (char == '@'){
                    domainIndex = i
                    domainStr.append(char)
                    break
                }else{
                    domainStr.append(char)
                }
            }
            var i = 0
            while (i < domainIndex){
                val char = string[i]
                if (char == '@'){
                    uniqueStr.append(char)
                    i += domainIndex
                }else{
                    if (char == '+'){
                        i += domainIndex
                    }else if (char == '.'){
                        i++
                    }else{
                        uniqueStr.append(char)
                        i++
                    }
                }
            }
            uniqueStr.append(domainStr.toString().reversed())
            set.add(uniqueStr.toString())
        }
        return set.size
    }
}