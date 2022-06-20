class `Most Stones Removed with Same Row or Column` {

    fun removeStones(stones: Array<IntArray>): Int {
        val array = IntArray(stones.size)
        val rank = IntArray(stones.size)
        for (i in array.indices) {
            array[i] = i
            rank[i] = 1
        }
        for (i in stones.indices) {
            for (j in i + 1 until stones.size) {
                val stoneA = stones[i]
                val stoneB = stones[j]
                if (stoneA[0] == stoneB[0] || stoneA[1] == stoneB[1]) {
                    union(i, j, array, rank)
                }
            }
        }
        var disjoints = 0
        for (i in array.indices) {
            if (array[i] == i) ++disjoints
        }
        return stones.size - disjoints
    }

    private fun union(stoneA: Int, stoneB: Int, array: IntArray, rank: IntArray): Boolean {
        val rootA = find(stoneA, array, rank)
        val rootB = find(stoneB, array, rank)
        if (rootA == rootB) return false
        if (rank[rootA] > rank[rootB]) {
            array[rootB] = rootA
        } else if (rank[rootB] > rank[rootA]) {
            array[rootA] = rootB
        } else {
            array[rootB] = rootA
            rank[rootA]++
        }
        return true
    }

    private fun find(stoneA: Int, array: IntArray, rank: IntArray): Int {
        if (array[stoneA] == stoneA) return stoneA
        return find(array[stoneA], array, rank)
    }
}