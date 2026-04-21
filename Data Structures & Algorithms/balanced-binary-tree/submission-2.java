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
    static boolean isBalanced;

    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        dfsTree(root);
        
        return isBalanced;
    }

    public int dfsTree(TreeNode root){
        if(root == null) return 0;

        int left = dfsTree(root.left);
        int right = dfsTree(root.right);

        if(Math.abs(left - right) > 1){
            isBalanced = false;
            return 0;
        }

        return 1 + Math.max(left ,right);
    }
}
