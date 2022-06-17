import kotlin.collections.ArrayList

class `Expressive Words` {

    fun expressiveWords(
        s: String,
        words: Array<String>
    ): Int {
        val pattern = buildList(s)
        var res = 0

        for (i in words.indices) {
            val word = buildList(words[i])
            if (canBeExtended(word, pattern))
                ++res
        }
        return res
    }

    private fun canBeExtended(
        word: ArrayList<Node1>,
        pattern: ArrayList<Node1>
    ): Boolean {
        if (pattern.size != word.size) return false
        for (i in pattern.indices) {
            if (pattern[i].char != word[i].char) return false
            if (pattern[i].freq == word[i].freq ) continue
            if (pattern[i].freq < word[i].freq ) return false
            if (pattern[i].freq <3) return false
        }
        return true
    }

    private fun buildList(s: String): ArrayList<Node1> {
        val list = ArrayList<Node1>()
        for (element in s) {
            if (list.isEmpty()) {
                list.add(Node1(element, 1))
            } else if (element == list.last().char) {
                list.last().freq++
            } else {
                list.add(Node1(element, 1))
            }

        }
        return list
    }

    data class Node1(val char: Char, var freq: Int) {
        override fun toString(): String {
            return "$char $freq"
        }
    }



}