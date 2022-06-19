import java.util.*

class `Minimum Cost to Connect Sticks` {

    fun connectSticks(sticks: IntArray): Int {
        if (sticks.isEmpty()) return 0
        val pq = PriorityQueue<Int>()
        sticks.forEach { pq.add(it) }
        var cost = 0
        while (pq.size > 1) {
            val smallest = pq.poll()
            val secondSmallest = pq.poll()
            cost += smallest + secondSmallest
            pq.offer( smallest + secondSmallest)
        }
        return cost
    }
}