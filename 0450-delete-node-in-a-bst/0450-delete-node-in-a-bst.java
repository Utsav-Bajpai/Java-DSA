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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) return newNode(root);
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = newNode(curr.left);
                    break;
                }
                else curr = curr.left;
            }else{
                if(curr.right != null && curr.right.val == key){
                    curr.right = newNode(curr.right);
                    break;
                }
                else curr = curr.right;
            }
        }
        return root;
    }
    TreeNode newNode(TreeNode root){
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else{
            TreeNode right = root.right;
            TreeNode extRight = root.left;
            while(extRight.right != null){
                extRight = extRight.right;
            }
            extRight.right = right;
            return root.left;
        }
    }
}