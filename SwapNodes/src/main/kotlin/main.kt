fun swapNodes(tree: TreeNode, queries: List<Int>): List<List<Int>> {
    fun swapNodesImpl(tree: TreeNode?, currentLevel: Int, query: Int) {
        if (tree == null) {
            return
        }
        if (currentLevel % query == 0) {
            tree.swapChildren()
        }
        swapNodesImpl(tree.left, currentLevel + 1, query)
        swapNodesImpl(tree.right, currentLevel + 1, query)
    }

    return queries.map {
        swapNodesImpl(tree, 1, it)
        tree.traverse()
    }
}

fun main() {
    val n = readLine()!!.trim().toInt()

    val nodes = Array<TreeNode?>(n) { null }
    val root = TreeNode(1)
    nodes[0] = root

    (0 until n).asSequence()
        .map { readLine()!!.split(" ").map { it.trim().toInt() } }
        .forEachIndexed { i, (left, right) ->
            val node = nodes[i]
            if (left != -1) {
                val childNode = TreeNode(left)
                node!!.left = childNode
                nodes[left - 1] = childNode
            }
            if (right != -1) {
                val childNode = TreeNode(right)
                node!!.right = childNode
                nodes[right - 1] = childNode
            }
        }
    val queriesCount = readLine()!!.trim().toInt()
    val queries = (0 until queriesCount).map { readLine()!!.trim().toInt() }

    val result = swapNodes(root, queries)
    result.forEach { println(it.joinToString(" ")) }
}

class TreeNode(private val label: Int, var left: TreeNode? = null, var right: TreeNode? = null) {

    fun swapChildren() {
        val t = left
        left = right
        right = t
    }

    fun traverse(): List<Int> {
        val result = ArrayList<Int>()

        fun traverseImpl(current: TreeNode?) {
            if (current == null) {
                return
            }
            traverseImpl(current.left)
            result.add(current.label)
            traverseImpl(current.right)
        }

        traverseImpl(this)
        return result
    }
}