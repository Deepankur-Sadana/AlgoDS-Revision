class `323 Number of Connected Components in an Undirected Graph` {

    fun countComponents(
        n: Int,
        edges: Array<IntArray>
    ): Int {
        val array = IntArray(n)
        for (i in array.indices) array[i] = i
        edges.forEach {
            union(it[0],it[1], array)
        }

        var res = 0
        for (i in array.indices) {
            if (array[i] == i)++res
        }

        return res
    }

    private fun union(a: Int, b: Int, array: IntArray) {
        val rootA = find(a, array)
        val rootB = find(b, array)
        if (rootA == rootB) return
        array[rootB] = rootA//quick union
    }

    //slow find
    private fun find(num: Int, array: IntArray) :Int{
        if (array[num] == num) return num
        return find(array[num],array)
    }


}