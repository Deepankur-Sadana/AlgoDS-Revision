class `The Earliest Moment When Everyone Become Friends` {


    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        val array = IntArray(n)
        logs.sortBy { it[0] }
        for (i in array.indices)
            array[i] = i
        logs.forEach {
            union(it[1], it[2], array)
            if (numBerOfRoots(array) == 1) return it[0]
        }
        return -1
    }

    fun numBerOfRoots(array: IntArray): Int {
        var roots = 0
        for (i in array.indices) if (array[i] == i) ++roots
        return roots
    }

    fun union(a: Int, b: Int, array: IntArray) {
        val rootA = find(a, array)
        val rootB = find(b, array)
        if (rootA == rootB) return
        array[rootA] = rootB

    }

    private fun find(a: Int, array: IntArray): Int {
        if (array[a] == a) return a
        return find(array[a], array)
    }

}