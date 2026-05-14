/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/


class Solution {
    fun cloneGraph(node: Node?): Node? {
        val oldToNewMap = mutableMapOf<Node?, Node?>()

        fun cloneNode(node: Node?): Node? {
            if (oldToNewMap.containsKey(node)) {
                return oldToNewMap[node]
            } else {
                val copy = Node(node!!.`val`) 
                oldToNewMap[node] = copy
                for (neighbor in node!!.neighbors) {
                    copy.neighbors.add(cloneNode(neighbor))
                }
                return copy
            }
        }

        return if (node == null ) null else cloneNode(node)
    }
}
