import java.util.*
import kotlin.collections.ArrayList




class MedianFinder() {
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue { a: Int, b: Int -> b - a }

    fun addNum(num: Int) {
        maxHeap.add(num)
        minHeap.add(maxHeap.poll())
        if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }

    }

    fun findMedian(): Double {
        // println("maxHeapSize = ${maxHeap.size} minHeapSize = ${maxHeap.size}")

        return if (minHeap.size > maxHeap.size) {
            minHeap.peek().toDouble()
        } else if (maxHeap.size > minHeap.size) maxHeap.peek().toDouble()
        else (minHeap.peek().toDouble() + maxHeap.peek().toDouble()) / 2

    }

}
/**

3       5       4

        8

max

min


        11

    23        83
32              76
**/