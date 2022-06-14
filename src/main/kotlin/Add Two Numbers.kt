class `Add Two Numbers` {


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var curr1 = l1
        var curr2 = l2
        var result: ListNode? = null
        var resultHead: ListNode? = null
        var carry = 0
        while (curr1 != null || curr2 != null) {
            var sum = 0
            if (curr1 != null) sum += curr1.`val`
            if (curr2 != null) sum += curr2.`val`
            sum += carry

            if (sum <= 9) carry = 0 else {
                carry = 1
                sum %= 10
            }

            if (result == null) {
                result = ListNode(sum)
                resultHead = result
            } else {
                result.next = ListNode(sum)
                result = result.next
            }

            if (curr1 != null) curr1 = curr1.next
            if (curr2 != null) curr2 = curr2.next
        }
        if (carry != 0)
            result?.next = ListNode(1)
        return resultHead
    }


}