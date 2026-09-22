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
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return maketree(preorder, inorder, 0, inorder.length - 1);
    }
    TreeNode maketree(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        root.left = maketree(preorder, inorder, start, i-1);
        root.right = maketree(preorder, inorder, i+1, end);
        return root;
    }
}