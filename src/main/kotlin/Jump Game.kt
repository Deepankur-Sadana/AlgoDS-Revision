class `Jump Game` {

    fun canJump(nums: IntArray): Boolean {
        if (nums.size < 2) return true
        var highestReachSoFar = 0
        for (i in nums.indices) {
            if (highestReachSoFar == i && nums[i] == 0) {
                return false
            } else {
                highestReachSoFar = Math.max(highestReachSoFar, i + nums[i])
            }
            if(highestReachSoFar == nums.size -1) return true
        }
        return true
    }
}