class `Longest Substring Without Repeating Characters` {




    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var l = 0
        var r = 0
        val map = HashSet<Char>()
        while (r < s.length) {
            val curr = s[r]
            if (map.contains(curr)) {
                while (map.contains(curr)){
                    map.remove(s[l])
                    l++
                }
                map.add(curr)
            } else {
                map.add(curr)
            }
            max = Math.max(max, (r - l + 1))
            r++
        }
        return max
    }


}