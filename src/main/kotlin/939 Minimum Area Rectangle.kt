class `939 Minimum Area Rectangle` {

    fun minAreaRect(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        val set = HashSet<String>()
        var min = Int.MAX_VALUE
        points.forEach { set.add("${it[0]},${it[1]}") }

        for (i in 0..points.size - 1) {
            for (j in i + 1..points.size - 1) {
                // println("i $i j $j")

                val a = points[i]
                val b = points[j]

                if (a[0] == b[0] || a[1] == b[1]) continue
                if (set.contains("${a[0]},${b[1]}") && set.contains("${b[0]},${a[1]}")) {
                    val area = Math.abs(b[0] - a[0]) * Math.abs(b[1] - a[1])
                    min = Math.min(area, min)
                }

            }
        }
        if (min == Int.MAX_VALUE) return 0
        return min
    }

}