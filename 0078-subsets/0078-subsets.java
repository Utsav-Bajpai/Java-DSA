class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subs(0, nums, ans, new ArrayList<>());
        return ans;
    }
    void subs(int idx, int[] nums, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            subs(i+1, nums, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}