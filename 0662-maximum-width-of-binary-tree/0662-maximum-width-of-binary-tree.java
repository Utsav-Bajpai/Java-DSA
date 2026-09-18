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
    class pair{
        TreeNode node;
        int num;
        pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<pair> q = new LinkedList<pair>();
        int ans = 0;
        q.offer(new pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                int id = q.peek().num - min;
                TreeNode Node = q.peek().node;
                q.poll();
                if(i == 0) first = id;
                if(i == size - 1) last = id;
                if(Node.left != null){
                    q.offer(new pair(Node.left, id * 2 + 1));
                }
                if(Node.right != null){
                    q.offer(new pair(Node.right, id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}