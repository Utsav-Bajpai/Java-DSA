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
    int idx;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return makeTree(inorder, postorder, 0, inorder.length-1);
    }
    TreeNode makeTree(int[] inorder, int[] postorder, int start, int end){
        if(start > end ) return null;
        int val = postorder[idx--];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        root.right = makeTree(inorder, postorder, i+1, end);
        root.left = makeTree(inorder, postorder, start, i-1);
        return root;
    }
}