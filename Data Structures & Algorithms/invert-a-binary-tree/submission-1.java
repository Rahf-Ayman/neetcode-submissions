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
     public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return root;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode temp = curr.right;
            curr.right = curr.left;
            curr.left = temp;
            if(curr.right != null) queue.add(curr.right);
            if(curr.left != null) queue.add(curr.left);
        }
        return root;
    }
}
