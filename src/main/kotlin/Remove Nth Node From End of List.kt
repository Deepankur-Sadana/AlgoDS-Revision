class `Remove Nth Node From End of List` {


    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        //a    b     c    d     e
        // null5
        var totalNodes = 0
        var curr = head
        while (curr != null) {
            curr = curr.next
            totalNodes++
        }
        val nodeToDeleteFromLeft = totalNodes - n + 1

        if (nodeToDeleteFromLeft == 1) { //to delete 1st node
            val newHead = head?.next
            head?.next = null
            return newHead
        }

        var currentIndex = 1
        curr = head
        while (curr != null) {
            if (currentIndex == nodeToDeleteFromLeft - 1) {
                val nextToCurr = curr.next
                curr.next = curr.next?.next
                nextToCurr?.next = null
                return head
            }
            curr = curr.next
            currentIndex++
        }
        return head
    }
}