class `Missing Ranges` {

    /**
     * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
    Output: ["2","4->49","51->74","76->99"]
     */

    fun findMissingRanges(
        nums: IntArray,
        lower: Int,
        upper: Int
    ): List<String> {
        if (nums.isEmpty()) {
            if(upper == lower) return listOf("$lower")
            else return listOf("$lower->$upper")


        }

        val res = ArrayList<String>()
        for (i in nums.indices) {
            if (i == 0 && lower < nums[i]) {

                val diff = nums[i] - lower
                if (diff >= 2) {
                    res.add("${lower}->${nums[i] - 1}")
                }else if(diff == 1){
                    res.add("${lower}")
                }

            }

            if (i != 0) { // not the first number
                val diff = nums[i] - nums[i - 1]
                if (diff > 2) {
                    res.add("${nums[i - 1] + 1}->${nums[i] - 1}")
                } else if (diff == 2) {
                    res.add("${nums[i] - 1}")
                }
            }

            if (i == nums.size - 1 && upper > nums[i]) {
                val diff = upper - nums[i]
                if (diff >= 2) {
                    res.add("${nums[i] + 1}->${upper}")
                } else {
                    res.add("${nums[i] + 1}")
                }

            }

        }
        return res
    }
}