@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
class `Container With Most Water` {

    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.size - 1

        while (r > l) {
            val area = Math.min(height[r], height[l]) * (r - l)
            max = Math.max(max, area)
            if (height[r] > height[l]) {
                l++
            } else {
                r--
            }
        }

        return max
    }
}