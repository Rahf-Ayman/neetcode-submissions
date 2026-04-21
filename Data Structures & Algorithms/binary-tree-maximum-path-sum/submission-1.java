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
    public int maxPathSum(TreeNode root) {
        int arr [] = new int [1];
        arr[0] = root.val;
        DFSmax(root,arr);
        return arr[0];
    }
    public static int DFSmax(TreeNode root ,int arr[]){
        if(root == null) return 0;
        
        int leftsum = DFSmax(root.right,arr);
        int rightsum = DFSmax(root.left,arr);
        
        leftsum = Math.max(0, leftsum);
        rightsum = Math.max(0, rightsum);
        arr[0] = Math.max(arr[0], root.val + leftsum + rightsum);
        
        return root.val + Math.max(leftsum,rightsum);
    }
}
