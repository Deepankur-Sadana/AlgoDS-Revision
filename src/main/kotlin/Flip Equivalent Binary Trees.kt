class `Flip Equivalent Binary Trees` {


    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        if (root1 != null && root2 == null) return false
        if (root2 != null && root1 == null) return false

        if (root1!!.`val` == root2!!.`val`)
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                    flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
        return false
    }


}