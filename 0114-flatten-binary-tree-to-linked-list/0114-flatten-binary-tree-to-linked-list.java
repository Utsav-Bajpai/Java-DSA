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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return;
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            if(node.right != null) stk.push(node.right);
            if(node.left != null) stk.push(node.left);
            q.offer(node);
        }
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            node.right = q.peek();
            node.left = null;
            System.out.println(node.val);
        }
    }
}