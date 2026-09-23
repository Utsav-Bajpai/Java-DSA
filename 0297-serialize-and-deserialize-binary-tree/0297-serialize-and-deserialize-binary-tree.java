/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder("");
        preorder(root, s);
        return s.toString();
        
    }
    void preorder(TreeNode root, StringBuilder s){
        if(root == null){
            s.append("null,");
            return;
        }
        s.append(root.val).append(",");
        preorder(root.left, s);
        preorder(root.right, s);
    }
    
    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] s = data.split(",");
        idx = 0;
        return makeTree(s);
    }
    TreeNode makeTree(String[] s){
        if(s[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[idx]));
        idx++;
        root.left = makeTree(s);
        root.right = makeTree(s);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));