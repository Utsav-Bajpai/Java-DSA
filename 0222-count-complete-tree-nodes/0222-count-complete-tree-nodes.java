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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = heightLeft(root);
        int rh = heightRight(root);
        if(lh == rh) return (2<<(lh)) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
    int heightLeft(TreeNode root){
        int height = 0;
        while(root.left != null){
            root = root.left;
            height++;
        }
        return height;
    }
    int heightRight(TreeNode root){
        int height = 0;
        while(root.right != null){
            root = root.right;
            height++;
        }
        return height;
    }
}