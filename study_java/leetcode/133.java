import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> visited = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        Node clone = new Node(node.val);
        visited.put(clone.val, clone);
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    Node newNeighbor = new Node(neighbor.val);
                    visited.put(newNeighbor.val, newNeighbor);
                    stack.push(neighbor);
                }

                visited.get(current.val).neighbors.add(visited.get(neighbor.val));
            }
        }

        return clone;
    }
}