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
    private TreeNode first, second, third, prev;
    void inorder(TreeNode root){

        if(root == null) return;
        inorder(root.left);
        if(prev != null && (prev.val > root.val)){
            if(first == null){
                first = prev;
                second = root;
            }else third = root;
        }
        prev = root;
        inorder(root.right);

    }
    public void recoverTree(TreeNode root) {
        first = second = third = null;
        if(root == null) return;
        inorder(root);
        if(third == null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }else{
            int temp = first.val;
            first.val = third.val;
            third.val = temp;
        }
        
    }
}