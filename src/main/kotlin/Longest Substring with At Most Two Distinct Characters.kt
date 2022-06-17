class `Longest Substring with At Most Two Distinct Characters` {


    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        if (s.length <= 2) return s.length

        val currentHolding = HashMap<Char, Int>()
        var l = 0
        var h = 0
        var max = Int.MIN_VALUE
        currentHolding[s[0]] = 1
        while (h < s.length) {
            if (containsAtMost2DistinctElements(currentHolding)) {
                max = Math.max(max , totalHoldings(currentHolding))
                h++
                if(h == s.length) break
                currentHolding.putIfAbsent(s[h], 0)
                currentHolding[s[h]] = currentHolding[s[h]]!! + 1
            } else {
                currentHolding[s[l]] = currentHolding[s[l]]!! - 1
                l++
            }
        }

        return max
    }

    private fun containsAtMost2DistinctElements(
        currentHolding: java.util.HashMap<Char, Int>
    ): Boolean {
        var sum = 0
        currentHolding.entries.forEach {
            if (it.value > 0) sum++
        }
        return sum <= 2
    }


    private fun totalHoldings(
        currentHolding: java.util.HashMap<Char, Int>
    ): Int {
        var sum = 0
        currentHolding.entries.forEach {
            sum += it.value
        }
        return sum
    }


}