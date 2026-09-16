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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        trp(root, 0, ans);
        return ans;
    }
    void trp(TreeNode root, int lvl, List<Integer> ans){
        if(root == null) return;
        if(ans.size() == lvl) ans.add(root.val);
        trp(root.right, lvl + 1, ans);
        trp(root.left, lvl + 1, ans);
    }
}