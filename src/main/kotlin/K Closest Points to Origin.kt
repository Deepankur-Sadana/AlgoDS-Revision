import java.util.*
import kotlin.collections.ArrayList

class `K Closest Points to Origin` {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val list = ArrayList<IntArray>()
        val pq = PriorityQueue { a: KPoint, b: KPoint -> a.dis - b.dis }
        points.forEach { pq.add(KPoint(it, it[0] * it[0] + it[1] * it[1])) }

        while (list.size < k) {
            list.add(pq.poll().point)
        }
        return list.toTypedArray()
    }
    data class KPoint(val point: IntArray, val dis: Int)


}