class `Merge Two Sorted Lists` {

    /**
     * [1,2,4]
     *
     * [1,3,4]
     */
    fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?
    ): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var list1 = list1
        var list2 = list2

        val preHead = ListNode(-1)
        var curr :ListNode?= preHead
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                curr?.next = list2
                break
            } else if (list2 == null) {
                curr?.next = list1
                break
            }
            if (list1.`val` < list2.`val`) {
                curr?.next = list1
                list1 = list1.next
                curr?.next?.next = null

            } else {
                curr?.next = list2
                list2 = list2.next
                curr?.next?.next = null
            }
            curr = curr?.next

        }

        return preHead.next
    }

}