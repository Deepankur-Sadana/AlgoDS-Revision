fun main(args: Array<String>) {

    `Minimum Window Substring`().minWindow(
        "ADOBECODEBANC",
        "ABC"
    )
}

class `Minimum Window Substring` {


    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""
        val currentHolding = HashMap<Char, Int>()
        val desiredHolding = HashMap<Char, Int>()

        t.forEach {
            desiredHolding.putIfAbsent(it, 0)
            desiredHolding[it] = desiredHolding[it]!! + 1
        }

        var l = 0
        var h = 0
        var min = Int.MAX_VALUE
        var shortestString = ""
        currentHolding[s.get(0)] = 1

        while (h < s.length) {

            val contains = containsAllNumbers(currentHolding, desiredHolding)

            if (contains) {
                if (h - l + 1 < min) {
                    min = h - l + 1
                    shortestString = s.substring(l, h + 1)
                }
                val leavingChar = s[l]
                currentHolding[leavingChar] = currentHolding[leavingChar]!! - 1
                ++l
            } else {
                ++h
                if (h == s.length) break
                val addingChar = s[h]
                currentHolding.putIfAbsent(addingChar, 0)
                currentHolding[addingChar] = currentHolding[addingChar]!! + 1
            }
        }
        return shortestString
    }

    private fun containsAllNumbers(
        currentHolding: HashMap<Char, Int>,
        desiredHolding: java.util.HashMap<Char, Int>
    ): Boolean {
        desiredHolding.entries.forEach { entry ->
            if (currentHolding[entry.key] == null) return false
            if (currentHolding[entry.key]!! < entry.value) return false
        }
        return true
    }


}