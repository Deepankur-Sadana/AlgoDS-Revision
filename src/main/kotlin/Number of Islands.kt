class `Number of Islands` {

    fun numIslands(grid: Array<CharArray>): Int {
        val seen = HashSet<String>()
        var count = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == '1' && seen.contains("$r,$c").not()) {
                    recurse(r,c,grid,seen)
                    ++count
                }
            }
        }
        return count
    }

    fun recurse(
        r: Int,
        c: Int,
        grid: Array<CharArray>,
        seen: HashSet<String>
    ) {


        for (i in directions.indices) {
            val pr = r + directions[i][0]
            val pc = c + directions[i][1]
            if (pr < 0 || pr >= grid.size || pc < 0 || pc >= grid[0].size) {
                continue
            }
            if (grid[pr][pc] == '0') continue
            val hashCode = "$pr,$pc"
            if (seen.contains(hashCode)) continue
            seen.add(hashCode)
            recurse(pr, pc, grid, seen)
        }
    }


    private val directions = arrayOf(
        arrayOf(0, -1),//l
        arrayOf(-1, 0),//t
        arrayOf(0, 1),//r
        arrayOf(1, 0)//b
    )
}