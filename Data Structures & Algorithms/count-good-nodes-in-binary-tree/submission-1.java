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
    public int goodNodes(TreeNode root) {
        return DFSGood(root,Integer.MIN_VALUE);
    }
    public int DFSGood(TreeNode root, int bigger){
        if(root == null) return 0;
        int left ;
        int right;
        if(root.val >= bigger){
            left = DFSGood(root.left,root.val) + 1;
            right = DFSGood(root.right,root.val);
        }else{
            left = DFSGood(root.left,bigger);
            right = DFSGood(root.right,bigger);
        }
        return left + right;
    }
}
