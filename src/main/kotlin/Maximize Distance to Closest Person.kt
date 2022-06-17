class `Maximize Distance to Closest Person` {

    // 0 1 2 3 4 5 6
    fun maxDistToClosest(seats: IntArray): Int {
        var max = 1
        var lastTakenSeat = -1

        //SCAN middle
        for (i in seats.indices) {
            if (seats[i] != 0) {//filled seat
                if (lastTakenSeat != -1) {
                    max = Math.max(max, (i - lastTakenSeat) / 2)
                }
                lastTakenSeat = i
            }
        }

        //scan LTR
        var i = 0
        while (i != seats.size) {
            if (seats[i] != 0) {
                max = Math.max(max, i)
                break
            }
            ++i
        }
        i = seats.size - 1
        //scan RTL
        while (i != -1) {
            if (seats[i] != 0) {
                max = Math.max(max, seats.size - i - 1)
                break
            }
            --i
        }

        return max

    }


}