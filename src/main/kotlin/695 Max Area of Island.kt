import java.util.*

class `695 Max Area of Island` {
    /**
     * DFS Iterative Stack
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val seen = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        var max = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (seen[r][c] || grid[r][c] == 0) continue
                val stack = Stack<IntArray>()
                seen[r][c] = true

                stack.add(intArrayOf(r, c))
                var sizeInThisDFS = 1
                while (stack.isNotEmpty()) {
                    val pop = stack.pop()

                    for (i in directions.indices) {
                        val direction = directions[i]
                        val pRow = pop[0] + direction[0]
                        val pCol = pop[1] + direction[1]
                        if (pRow < 0 || pRow >= grid.size || pCol < 0 || pCol >= grid[0].size || grid[pRow][pCol] == 0 || seen[pRow][pCol]) {
                            continue
                        }
                        stack.push(intArrayOf(pRow, pCol))
                        sizeInThisDFS++
                        seen[pRow][pCol] = true
                    }

                }

                max = Math.max(sizeInThisDFS, max)
            }
        }
        return max
    }







    private val directions = arrayOf(
        arrayOf(0, -1),//l
        arrayOf(-1, 0),//t
        arrayOf(0, 1),//r
        arrayOf(1, 0)//b
    )


}
/**
[[1,1,0,0,0],
[1,1,0,0,0],
[0,0,0,1,1],
[0,0,0,1,1]]
 **/