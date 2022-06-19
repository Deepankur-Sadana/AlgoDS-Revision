import java.util.*
import kotlin.collections.ArrayList

class `Merge Intervals` {

    /**
     *  [[1,3],[2,6],[8,10],[15,18]]
     */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()
        intervals.sortBy { it[0] }
        val res = ArrayList<IntArray>()
        res.add(intervals[0])
        for (i in 1 until intervals.size) {
            val last = res.last()
            val thisInterval = intervals[i]
            if (canMerge(last, thisInterval)){
                last[1] = Math.max(last[1], thisInterval[1])
            } else {
                res.add(thisInterval)
            }
        }
        return res.toTypedArray()
    }

    private fun canMerge(last: IntArray, thisInterval: IntArray): Boolean {
        if (last[1] >= thisInterval[0]) return true
        return false
    }

}

