import java.util.*
import kotlin.collections.ArrayList

class `Merge Intervals` {

    /**
     *  [[1,3],[2,6],[8,10],[15,18]]
     */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val res = ArrayList<IntArray>()
        for (element in intervals) {
            val thisInterval = element
            if (res.isEmpty()) {
                res.add(thisInterval)
                continue
            } else {
                val last = res.last()
                if (last[1] >= thisInterval[0]) {
                    last[1] = Math.max(last[1], thisInterval[1])
                } else {
                    res.add(thisInterval)
                }
            }
        }
        return res.toTypedArray()
    }


}

