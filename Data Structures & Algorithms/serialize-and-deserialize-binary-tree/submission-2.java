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

public class Codec {

    // Encodes a tree to a single string.
     public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfsSerialize(root,res);

        return String.join(",",res);
    }

    public  void dfsSerialize(TreeNode root, ArrayList<String> res){
        if(root == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left,res);
        dfsSerialize(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        int []i ={0};
        return dfsDeserialize(res,i);
    }
    public  TreeNode dfsDeserialize(String[] res, int []i){
        if(res[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(res[i[0]++]));
        node.left = dfsDeserialize(res,i);
        node.right = dfsDeserialize(res,i);

        return node;

    }
}
