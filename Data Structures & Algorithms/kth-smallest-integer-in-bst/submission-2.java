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
     int i = 0;
   int c = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        c = 0;  
        i = 0;   
        DFSK(root, k);
        return i;
    }

    private void DFSK(TreeNode root, int k) {
        if (root == null) return;

        DFSK(root.left, k);

        c++;
        if (c == k) {
            i = root.val;
            return;
        }

        DFSK(root.right, k);
    }
}
