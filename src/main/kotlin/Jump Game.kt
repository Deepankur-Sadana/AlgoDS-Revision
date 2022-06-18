class `Jump Game` {

    fun canJump(nums: IntArray): Boolean {
        var leftMostReach  = nums.size -1
        for (i in nums.size - 1 downTo 0) {
            if (i + nums[i] >= leftMostReach)
                leftMostReach = i

        }
        return leftMostReach == 0
    }
}