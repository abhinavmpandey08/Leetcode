/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        List<Node> nodes = new ArrayList<Node>();
        return copyRandomList(head, nodes);
    }
    
    private Node copyRandomList(Node curr, List<Node> nodes) {
        if (curr == null)
            return null;
        
        Node next = copyRandomList(curr.next, nodes);
        if (next != null)
            nodes.add(next);
        
        
        Node newNode = findNode(curr, nodes);
        
        if (newNode == null) {
            newNode = new Node(curr.val, null, null);
            nodes.add(newNode);
        }
        
        newNode.next = next;       
        
        if (curr.random != null) {
            Node rand = findNode(curr.random, nodes);
            if (rand == null)  {
                rand = new Node(curr.random.val, null, null);
                nodes.add(rand);
            }
            newNode.random = rand;
        }
        
        return newNode;
    }
    
    private Node findNode(Node node, List<Node> nodes) {
        for (Node n : nodes)
            if (n.val == node.val)
                return n;
        
        return null;
    }
}