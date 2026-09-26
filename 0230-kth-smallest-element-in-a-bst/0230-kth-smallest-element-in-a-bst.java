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
    public int kthSmallest(TreeNode root, int k) {
        int cnt = 1;
        int kth = 0;
        while(root != null){
            if(root.left == null){
                if(cnt == k) {
                    kth = root.val;
                    return root.val;
                }
                cnt++;
                root = root.right;
            }else{
                TreeNode ip = root.left;
                while(ip.right != null && ip.right != root){
                    ip = ip.right;
                }
                if(ip.right == null){
                    ip.right = root;
                    root = root.left;
                }else{
                    ip.right = null;
                    if(cnt == k) {
                        kth = root.val;
                        return root.val;
                    }
                    cnt++;
                    root = root.right;
                }

            }
        }
        return kth;
    }
}