class `Peak Index in a Mountain Array` {


    fun peakIndexInMountainArray(arr: IntArray): Int {
        if (arr.size == 3) return 1
        var l = 0
        var h = arr.size - 1
        while (l < h) {
            val m = (l + h) / 2

            if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m
            }
            if (arr[m] > arr[m - 1]) {
                l = m
            } else if (arr[m] < arr[m - 1]) {
                h = m
            }
        }
        return -1
    }
}