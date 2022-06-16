class `3Sum` {


    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        if (nums.isEmpty()) return emptyList()
        val res = ArrayList<ArrayList<Int>>()
        val seen = HashSet<String>()
        for (i in nums.indices) {
            var l = i + 1
            var h = nums.size - 1
            while (l < h) {
                val sum = nums[i] + nums[l] + nums[h]
                if (sum == 0) {
                    val hashCode = "${nums[i]},${nums[l]}${nums[h]}"
                    if (seen.contains(hashCode).not())
                        res.add(arrayListOf(nums[i], nums[l], nums[h]))
                    seen.add(hashCode)
                    ++l
                    --h
                } else if (sum > 0) --h
                else ++l
            }
        }
        return res
    }


}