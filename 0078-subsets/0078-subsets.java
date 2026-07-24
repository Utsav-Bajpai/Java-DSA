class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int num = 0; num < (1 << nums.length); num++){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((num &(1 << i)) == 0) ds.add(nums[i]);
            }
            ans.add(ds);
        }
        return ans;
    }
}