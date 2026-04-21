/*
Definition for a Node.
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
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        DFS(node,map);
        return map.get(node);
    }
    
    public void DFS(Node node,HashMap<Node,Node> map ){
        if(map.get(node) != null) return;
        Node newnode = new Node(node.val);
        map.put(node,newnode);
        ArrayList<Node> newarr = new ArrayList<>();
        for(Node nei : node.neighbors){
            DFS(nei,map);
            newarr.add(map.get(nei));
        }
        newnode.neighbors = newarr;
    }
}