import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class `Smallest String With Swaps` {


    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        var s = s
        val array = IntArray(s.length)
        for (i in array.indices) {
            array[i] = i
        }

        pairs.forEach { union(it[0], it[1], array) }
        println(array.contentToString())

        compressPath(array)
        val rootToLeafMap = HashMap<Int, ArrayList<Int>>()
        val rootToCharListMap = HashMap<Int, LinkedList<Char>>()
        for (i in array.indices) {
            val root = array[i]
            rootToLeafMap.putIfAbsent(root, ArrayList())
            rootToCharListMap.putIfAbsent(root, LinkedList())

            rootToLeafMap[root]!!.add(i)
            rootToCharListMap[root]!!.add(s[i])
        }
        val charArray = s.toCharArray()

        rootToLeafMap.forEach { rootToNodeMapEntry ->
            val charList = rootToCharListMap[rootToNodeMapEntry.key]
            charList!!.sortBy { it }
            val listOfIndicesToReplace = rootToNodeMapEntry.value

            for (i in listOfIndicesToReplace.indices) {
                charArray[listOfIndicesToReplace[i]] = charList.poll()
            }

        }

        return charArray.joinToString("")
    }

    private fun compressPath(array: IntArray) {
        for (i in array.indices)
            array[i] = find(i, array)
    }
    private fun union(a: Int, b: Int, array: IntArray) {
        val rootA = find(a, array)
        val rootB = find(b, array)
        if(rootA == rootB) return
        array[rootA] = rootB

    }


    private fun find(a: Int, array: IntArray): Int {
        if (array[a] == a) return a
        return find(array[a], array)
    }


}