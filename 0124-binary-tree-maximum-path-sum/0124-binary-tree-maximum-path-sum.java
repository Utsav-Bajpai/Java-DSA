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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;

        totald(root, maxSum);

        return maxSum[0];
    }

    int totald(TreeNode root, int[] maxSum) {
        if (root == null) return 0;

        int lv = Math.max(0, totald(root.left, maxSum));
        int rv = Math.max(0, totald(root.right, maxSum));

        // Path passing through current node
        int currentPath = lv + root.val + rv;

        // Update global maximum
        maxSum[0] = Math.max(maxSum[0], currentPath);

        // Return best one-sided path to parent
        return root.val + Math.max(lv, rv);
    }
}