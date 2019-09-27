/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        HashSet<Integer> visited = new HashSet<Integer>();
        List<Node> nodes = new ArrayList<Node>();
        return cloneGraph(node, visited, nodes);
        
    }
    
    private Node cloneGraph(Node node, Set<Integer> visited, List<Node> nodes) {
        if (visited.contains(node.val)) {
            return findNode(node.val, nodes);
        }
        
        visited.add(node.val);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        nodes.add(newNode);
        
        for (Node n: node.neighbors)
            newNode.neighbors.add(cloneGraph(n, visited, nodes));
        
        return newNode;
    }
    
    private Node findNode(int val, List<Node> nodes) {
        for (Node n: nodes)
            if (n.val == val)
                return n;
        
        //Code should never reach here.
        return null;
    }
}