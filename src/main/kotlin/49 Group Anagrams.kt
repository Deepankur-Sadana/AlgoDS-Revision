class `49 Group Anagrams` {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, ArrayList<String>>()

        strs.forEach {
            val hashTable = IntArray(26)
            it.toCharArray().forEach { char ->
                hashTable[char - 'a']++
            }
            var hashCode = ""
            for (i in hashTable.indices){
                if (hashTable[i] > 0) hashCode += "${'a' + i}:${hashTable[i]}"
            }
            map.putIfAbsent(hashCode, ArrayList())
            map[hashCode]!!.add(it)
        }
        val res = ArrayList<ArrayList<String>>()
        map.entries.forEach {
            val subList = ArrayList<String>()
            subList.addAll(it.value)
            res.add(subList)
        }
        return res
    }
}