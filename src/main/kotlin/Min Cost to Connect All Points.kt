class `Min Cost to Connect All Points` {


    //using kruskal's
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val allEdges = ArrayList<IntArray>()
        for (i in points.indices) {
            for (j in i + 1 until points.size) {
                val weight = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1])
                allEdges.add(intArrayOf(weight, i, j))
            }
        }
        val array = IntArray(points.size)
        val rank = IntArray(points.size)
        for (i in array.indices) {
            array[i] = i
            rank[i] = 1
        }

        allEdges.sortBy { it[0] }

        var edgesBuilt = 0
        var totalWeight = 0

        for (i in allEdges.indices) {
            val edge = allEdges[i]
            if (union(edge[1], edge[2], array , rank)){
                ++edgesBuilt
                totalWeight += edge[0]
            }
        }

        println(rank.contentToString())

        return totalWeight
    }

    private fun union(a: Int, b: Int, array: IntArray, rank: IntArray) :Boolean{
        val rootA = find(a, array)
        val rootB = find(b, array)
        if (rootA == rootB) return false
        if (rank[rootA] > rank[rootB]) {
            array[rootB] = rootA
        }else if (rank[rootB] > rank[rootA]) {
            array[rootA] = rootB
        }else {// sam rank
            array[rootB] = rootA
            rank[rootA] += 1
        }

//        array[rootB] = rootA
        return true
    }

    private fun find(a: Int, array: IntArray): Int {
        if (array[a] == a) return a
        return find(array[a], array)
    }


}