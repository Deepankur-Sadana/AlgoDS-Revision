class `Maximize Distance to Closest Person` {

    // 0 1 2 3 4 5 6
    fun maxDistToClosest(seats: IntArray): Int {
        var max = 1
        var lastTakenSeat = -1
        for (i in seats.indices) {
            if (seats[i] != 0) {//filled seat
                if (lastTakenSeat != i - 1) {
                    val distance = i - lastTakenSeat
                    if (distance % 2 == 0) {// odd no of seats bwn 2 people
                        max = Math.max(max, distance / 2)
                    } else {
                        max = Math.max(max, distance / 2)
                    }
                }
                lastTakenSeat = i
            } else {//vacant seat
                if (i == seats.size - 1)
                    max = Math.max(max, (i - lastTakenSeat))
                else if(lastTakenSeat == -1)
                    max = Math.max(max, (i - lastTakenSeat))
                else
                    max = Math.max(max, (i - lastTakenSeat) / 2)

            }

        }
        return max

    }


}