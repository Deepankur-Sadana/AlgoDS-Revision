import java.util.*
import kotlin.collections.ArrayList

class `Binary Tree Preorder Traversal` {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()
        recurse(root, res)
        return res
    }

    fun recurse(root: TreeNode?, list: ArrayList<Int>) {
        if (root == null) return
        recurse(root.left, list)
        list.add(root.`val`)
        recurse(root.right, list)
    }
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val res = ArrayList<ArrayList<Int>>()
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val subList = ArrayList<Int>()
        val nodesAtThisLevel = ArrayList<TreeNode>()

        while (queue.isNotEmpty()){
            nodesAtThisLevel.add(queue.poll())
        }
        nodesAtThisLevel.forEach { node ->
            subList.add(node.`val`)
            node.left?.let { queue.add(it) }
            node.right?.let {  queue.add(it)}
        }
        res.add(subList)
    }
    return res
}