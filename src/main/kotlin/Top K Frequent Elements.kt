import java.util.*
import kotlin.collections.HashMap

class `Top K Frequent Elements` {
    /**
     * Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
     */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val pq = PriorityQueue{a:IntArray, b : IntArray -> -a[1] + b[1]}
        val map = HashMap<Int, Int>()
        nums.forEach { num ->
            map.putIfAbsent(num,0)
            map[num] = map[num]!! + 1
        }
        map.forEach { pq.add(intArrayOf(it.key, it.value)) }
        val res = IntArray(k)
        for (i in res.indices) res[i] = pq.poll()[0]
        return res
    }
}