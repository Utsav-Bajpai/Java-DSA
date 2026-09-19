/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void findParent(HashMap<TreeNode, TreeNode> map, TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                map.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        findParent(map, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int lvl = 0;
        q.offer(target);
        visited.put(target, true);
        while(!q.isEmpty()){
            int size = q.size();
            if(lvl == k) break;
            lvl++;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    visited.put(curr.left, true);
                    q.offer(curr.left);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    visited.put(curr.right, true);
                    q.offer(curr.right);
                }
                if(map.get(curr) != null && visited.get(map.get(curr)) == null){
                    visited.put(map.get(curr), true);
                    q.offer(map.get(curr));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}