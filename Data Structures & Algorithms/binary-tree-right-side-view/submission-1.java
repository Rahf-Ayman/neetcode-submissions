/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if(root == null) return res;
        queue.add(new Node(root,0));
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if(res.size() < curr.l + 1) res.add(curr.node.val);
            if(curr.node.right  != null)
            queue.add(new Node(curr.node.right ,curr.l + 1));
            if(curr.node.left  != null)
            queue.add(new Node(curr.node.left ,curr.l + 1));
        }
        return res;
    }
}
class Node {
    TreeNode node;
    int l = 0;
    public Node(TreeNode node,int l){
        this.node = node;
        this.l = l;
    }

}