//import practice.substringCheck

//    Test input for 1st problem
//    val input = listOf<String>(
//        "programming",
//        "java",
//        "kotlin",
//        "algorithm",
//        "array",
//        "programming"
//    )
//    val subString = "ra"


fun main() {
    val node1 = Node(1, "Node A", null)
    val node2 = Node(2, "Node B", 1)
    val node3 = Node(3, "Node C", 1)
    val node4 = Node(4, "Node D", 2)
    val node5 = Node(5, "Node E", 2)
    val node6 = Node(6, "Node F", null)
    val node7 = Node(7, "Node G", 6)
    val node8 = Node(8, "Node H", 1)
    val inputNodeObjectsList = listOf(node1, node2, node3, node4, node5, node6, node7, node8)
    val initialChildrenList = mutableListOf<Node>()
    val initialParent = null
    val treeObjectsList = flatArrayToTree(inputNodeObjectsList, initialParent, initialChildrenList)
    flattenTreeIdPrinter(treeObjectsList)
    println(inputNodeObjectsList.toString())
}
data class Node(
    val id: Int,
    val name: String,
    val parent: Int?,
    var children: MutableList<Node> = mutableListOf()
)
fun flatArrayToTree(
    nodeObjectsList: List<Node>,
    parent: Int?,
    children: MutableList<Node> = mutableListOf()
): List<Node> {
    for (node in nodeObjectsList) {
        if (node.parent == parent) {
            children.add(node)
            val listAfterRemovingCurrentNode =
                nodeObjectsList.filter { nodeElement: Node -> nodeElement.id != node.id }
            flatArrayToTree(listAfterRemovingCurrentNode, node.id, node.children)
        }
    }
    return children
}
fun flattenTreeIdPrinter(tree: List<Node>){
    for (node in tree){
        println("CurrentNode : ${node.id}")
        println("CurrentNode Children : ${node.children}")
        if (node.children.size >= 1){
            flattenTreeIdPrinter(node.children)
        }
    }
}
