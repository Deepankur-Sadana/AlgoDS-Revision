class `Copy List with Random Pointers` {




    fun copyRandomList(node: Node?): Node? {
        val seen = HashSet< Node>()
        val map = HashMap<Node, Node>()
        traverse(node, map, seen)
        print("seenSize ${seen.size}")
        map.entries.forEach { mapEntry ->
            val thisNode = mapEntry.key
            val deepCopyOfThisNode = mapEntry.value
            deepCopyOfThisNode.next = map[thisNode.next]
            deepCopyOfThisNode.random = map[thisNode.random]
        }
        return map[node]
    }


    fun traverse(
        node : Node?,
        map : HashMap<Node,Node>,
        seen : HashSet<Node>
    ){
        if (node == null || seen.contains(node)) return
        seen.add(node)
        map[node] = Node(node.`val`)
        traverse(node.next, map, seen)
        traverse(node.random, map, seen)
    }


}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}