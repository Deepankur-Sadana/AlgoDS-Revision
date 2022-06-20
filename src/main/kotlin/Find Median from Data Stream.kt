import java.util.*
import kotlin.collections.ArrayList

class `Find Median from Data Stream` {
}


class MedianFinder() {
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue { a: Int, b: Int -> b - a }

    fun addNum(num: Int) {

        val pop = ArrayList<Int>()
        if (minHeap.isNotEmpty()) pop.add(minHeap.poll())
        if (maxHeap.isNotEmpty()) pop.add(maxHeap.poll())
        pop.add(num)
        pop.sortBy { it }
        if(pop.size == 1){
            maxHeap.add(pop[0])
        } else if (pop.size == 2) {
            maxHeap.add(pop[0])
            minHeap.add(pop[1])
        } else { //pop == 3
            maxHeap.add(pop[0])
            minHeap.add(pop[2])
            if (minHeap.size < maxHeap.size) {
                minHeap.add(pop[1])
            } else if (maxHeap.size < minHeap.size) {
                maxHeap.add(pop[1])
            } else {
                minHeap.add(pop[1])
            }

        }
        // println("added $num maxHeapSize = ${maxHeap.size} minHeapSize = ${maxHeap.size}")


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