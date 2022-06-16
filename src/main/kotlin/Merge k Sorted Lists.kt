import java.util.*

class `Merge k Sorted Lists` {


    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val pq = PriorityQueue { t1: ListNode, t2: ListNode -> t1.`val` - t2.`val` }
        val preHead = ListNode(-1)
        var curr: ListNode? = preHead
        lists.forEach { if (it!=null)pq.add(it) }

        while (pq.isNotEmpty()) {
            val poll = pq.poll()
            curr?.next = poll
            val pollNext = poll.next
            if (pollNext != null)
                pq.add(pollNext)
            curr!!.next?.next = null
            curr = curr.next
        }
        return preHead.next
    }


}