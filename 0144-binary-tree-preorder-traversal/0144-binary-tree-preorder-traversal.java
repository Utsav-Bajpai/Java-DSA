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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     preOrder(root, res);
    //     return res;
    // }
    // void preOrder(TreeNode root, List<Integer> ls){
    //     if(root == null) return;
    //     ls.add(root.val);
    //     preOrder(root.left, ls);
    //     preOrder(root.right, ls);
    // }
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     Stack<TreeNode> stk = new Stack<>();
    //     List<Integer> lst = new ArrayList<>();
    //     if(root == null) return lst;
    //     stk.push(root);
    //     while(!stk.isEmpty()){
    //         TreeNode node = stk.pop();
    //         if(node.right != null) stk.push(node.right);
    //         if(node.left != null) stk.push(node.left);
    //         lst.add(node.val);
    //     }
    //     return lst;
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        while(root != null){
            if(root.left == null){
                ls.add(root.val);
                root = root.right;
            }else{
                TreeNode pp = root.left;
                while(pp.right != null && pp.right != root){
                    pp = pp.right;
                }
                if(pp.right == null){
                    pp.right = root;
                    ls.add(root.val);
                    root = root.left;
                }else{
                    pp.right = null;
                    root = root.right;
                }
            }
        }
        return ls;
    }
}