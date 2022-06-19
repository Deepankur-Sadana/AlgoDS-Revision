import kotlin.collections.ArrayList

class `Merge Intervals` {

    /**
     *  [[1,3],[2,6],[8,10],[15,18]]
     */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val res = ArrayList<IntArray>()
        for (element in intervals) {
            if (res.isEmpty()) {
                res.add(element)
                continue
            } else {
                val last = res.last()
                if (last[1] >= element[0]) {
                    last[1] = Math.max(last[1], element[1])
                } else {
                    res.add(element)
                }
            }
        }
        return res.toTypedArray()
    }


}

/**With Union finf**/
class MergeIntervalUnionFind {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val res = ArrayList<IntArray>()
        val array = IntArray(intervals.size)
        val rank = IntArray(intervals.size)
        for (i in array.indices) {
            array[i] = i
            rank[i] = 1
        }


        for (i in intervals.indices) {
            for (j in i + 1 until intervals.size) {
                val firstInterval = intervals[i]
                val secondInterval = intervals[j]
                if (doesOverLap(firstInterval, secondInterval)) {
                    union(i, j, array, rank)
                }
            }
        }
        val map = HashMap<Int, ArrayList<IntArray>>()
        for (i in array.indices) {
            val root = array[i]
            map.putIfAbsent(root, ArrayList())
            map[root]!!.add(intervals[i])
        }
        map.entries.forEach { mapEntry ->
            var low = Int.MAX_VALUE
            var high = Int.MIN_VALUE
            mapEntry.value.forEach {
                low = Math.min(low, it[0])
                high = Math.max(high, it[1])
            }
            res.add(intArrayOf(low, high))
        }
        res.sortBy { it[0] }

        return res.toTypedArray()

    }

    private fun union(firstIntervalIndex: Int, secondIntervalIndex: Int, array: IntArray, rank: IntArray): Boolean {
        val rootA = find(firstIntervalIndex, array)
        val rootB = find(secondIntervalIndex, array)
        if (rootA == rootB) return false
        if (rank[rootA] > rank[rootB]) {
            array[rootB] = rootA
        } else if (rank[rootB] > rank[rootA]) {
            array[rootA] = rootB
        } else { // equal rankers
            array[rootB] = rootA
            rank[rootA]++
        }
        return true
    }

    private fun find(a: Int, array: IntArray): Int {
        if (array[a] == a) return a
        return find(array[a], array)

    }

    private fun doesOverLap(firstInterval: IntArray, secondInterval: IntArray): Boolean {
        val smaller: IntArray
        val larger: IntArray
        if (firstInterval[0] <= secondInterval[0]) {
            smaller = firstInterval
            larger = secondInterval
        } else {
            smaller = secondInterval
            larger = firstInterval
        }
        return smaller[1] >= larger[0]
    }


}
