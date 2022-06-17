class `Number of Provinces` {

    fun findCircleNum(graph: Array<IntArray>): Int {
        val array = IntArray(graph.size)
        for (i in array.indices) array[i] = i

        for (r in graph.indices) {
            for (c in graph[0].indices) {
                if (r != c && graph[r][c] == 1) {
                    union(r, c, array, graph)
                }
            }
        }
        var res = 0
        for (i in array.indices)
            if (array[i] == i) ++res
        return res
    }

    private fun union(a: Int, b: Int, array: IntArray, graph: Array<IntArray>) {
        val rootA = findRoot(a, array)
        val rootB = findRoot(b, array)
        if (rootA == rootB) return // already connected
        array[rootB] = rootA
    }

    // slow find, recursion !
    private fun findRoot(num: Int, array: IntArray): Int {
        return if (array[num] == num) num
        else findRoot(array[num], array)
    }




}