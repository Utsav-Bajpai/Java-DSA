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
    class BSTIterator{
        private Stack<TreeNode> stk = new Stack<>();
        boolean rev = true;
        public BSTIterator(TreeNode root, boolean rev){
            this.rev = rev;
            allpush(root);
        }
        boolean isnext(){
            return !stk.isEmpty();
        }
        void allpush(TreeNode root){
            while(root != null){
                stk.push(root);
                if(rev == true){
                    root = root.right;
                }else{
                    root = root.left;
                }
            }
        }
        int next(){
            TreeNode node = stk.pop();
            if(rev) allpush(node.left);
            else allpush(node.right);
            return node.val;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}