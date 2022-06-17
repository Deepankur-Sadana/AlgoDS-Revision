
class `Rotate Image` {


    /**
     *  0,0     0,1     0,2     0,3     0,4     0,5
     *
     *
     *  1,0     1,1     1,2     1,3     1,4     1,5
     *
     *
     *  2,0     2,1     2,2     2,3     2,4     2,5
     *
     *
     *  3,0     3,1     3,2     3,3     3,4     3,5
     *
     *
     *  4,0     4,1     4,2     4,3     4,4     4,5
     *
     *
     *  5,0     5,1     5,2     5,3     5,4     5,5
     */

    fun rotate(matrix: Array<IntArray>) {
        val size = matrix.size
        val swapLoops = matrix.size / 2
        var loop = 0
        println("swapLoops $swapLoops")
        while (loop < swapLoops) {
            val top = Point(loop, loop)
            val right = Point(loop, size - loop -1)
            val bottom = Point(size - loop -1 , size - loop -1 )
            val left = Point(size - loop - 1, loop)
            val edgesElementsToSwapInThisRound = size - (loop * 2) - 1

            println("top $top right $right bottom $bottom left $left")
            println("edgesElementsToSwapInThisRound $edgesElementsToSwapInThisRound")
            for (i in 0 until edgesElementsToSwapInThisRound) {

                val temp = matrix[top.r][top.c]
                matrix[top.r][top.c] = matrix[left.r][left.c]
                matrix[left.r][left.c] = matrix[bottom.r][bottom.c]
                matrix[bottom.r][bottom.c] = matrix[right.r][right.c]
                matrix[right.r][right.c] = temp

                top.c++
                right.r++
                bottom.c--
                left.r--
            }


            ++loop
        }

    }

    data class Point(var r:Int,var c:Int){
        override fun toString(): String {
            return "r:$r c:$c"
        }
    }
}
