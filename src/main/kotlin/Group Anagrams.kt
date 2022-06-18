class `Group Anagrams` {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, ArrayList<String>>()
        val res = ArrayList<ArrayList<String>>()

        strs.forEach { word ->
            val hashCode = HashMap<Char,Int>()
            word.forEach { char ->
                if (hashCode[char] == null) hashCode[char] = 0
                hashCode[char] = hashCode[char]!! + 1
            }
        }
        map.entries.forEach { res.add(it.value) }
        return res
    }

}