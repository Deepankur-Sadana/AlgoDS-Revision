import java.util.*

class `Kth Largest Element in an Array` {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        if (k > nums.size) return -1
        val pq = PriorityQueue { a: Int, b: Int -> b - a }
        nums.forEach { pq.add(it) }

        var count = 0
        while (pq.isNotEmpty()) {
            val poll = pq.poll()
            ++count
            if (count == k) return poll
        }
        return -1
    }
}