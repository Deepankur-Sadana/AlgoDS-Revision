import java.util.*

class `Last Stone Weight` {

    fun lastStoneWeight(stones: IntArray): Int {
        if (stones.isEmpty()) return 0
        val pq = PriorityQueue { a: Int, b: Int -> b - a }
        stones.forEach { pq.add(it) }

        while (pq.size > 1) {
            val x = pq.poll()
            val y = pq.poll()
            if (x != y) pq.offer(Math.abs( x - y))
        }
        return if(pq.isEmpty()) 0 else pq.poll()
    }
}