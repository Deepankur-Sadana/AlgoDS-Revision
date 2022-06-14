class `Longest Substring Without Repeating Characters` {




    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var l = 0
        var r = 0
        val map = HashMap<Char, Int>()
        while (r < s.length) {
            val curr = s[r]
            if (map.containsKey(curr)) {
                while (map.containsKey(curr)){
                    map.remove(s[l])
                    l++
                }
                map[curr] = 0
            } else {
                map[curr] = 0
            }
            max = Math.max(max, (r - l + 1))
            r++
        }
        return max
    }


}