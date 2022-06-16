class `Meeting Rooms II` {

    /**
     * Input: intervals = [[0,30],[5,10],[15,20]]
    Output: 2
     */
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val list = ArrayList<Instance>()
        intervals.forEach {
            list.add(Instance(it[0],Type.START))
            list.add(Instance(it[1],Type.END))
        }

        val sortedList = list
            .sortedWith(object : Comparator <Instance> {
                override fun compare (p0: Instance, pi: Instance) : Int {
                    if (p0.time != pi.time) {
                        return p0.time - pi.time
                    }
                    if (p0.type != pi.type) {
                        return -p0.type.compareTo(pi.type)
                    }
                    return 0
                }
            })

        var roomsOccupied = 0
        var maxRooms = 0
        sortedList.forEach {
            if (it.type == Type.START) ++ roomsOccupied
            else --roomsOccupied
            maxRooms = Math.max(maxRooms, roomsOccupied)
        }
        return  maxRooms
    }

    enum class Type {START,END}
    class Instance(val time: Int,val type: Type)
}