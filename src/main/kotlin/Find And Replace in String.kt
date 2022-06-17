class `Find And Replace in String` {

    data class Operation(val index: Int, val source: String, val target: String)


    fun findReplaceString(
        s: String,
        indices: IntArray,
        sources: Array<String>,
        targets: Array<String>
    ): String {
        var s = s
        val list = ArrayList<Operation>()
        for (i in indices.indices) {
            list.add(Operation(indices[i], sources[i], targets[i]))
        }
        list.sortByDescending { it.index }
        for (i in list.indices){
            val operation = list[i]
            val totalLengthShootingFor = operation.index + operation.source.length
            if (totalLengthShootingFor > s.length) continue
            val substring = s.substring(operation.index, operation.index + operation.source.length )
            println("substring $substring")
            if (substring == operation.source) {
                s = s.removeRange(operation.index, operation.index + operation.source.length)
                s = s.replaceRange(operation.index,operation.index,operation.target)
                println("$s")
            }
        }

        return s
    }


}