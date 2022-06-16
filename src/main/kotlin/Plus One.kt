class `Plus One` {

    fun plusOne(digits: IntArray): IntArray {

        for (i in digits.size - 1 downTo 0) {
            if (digits[i] + 1 < 10) {
                digits[i] += 1
                return digits
            }
            else digits[i] = 0
        }
        val digits = IntArray(digits.size+1);
        digits[0]=1
        return digits

    }








}