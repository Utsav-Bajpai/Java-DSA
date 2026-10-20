class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        return ways(nums.length-1, sum, nums, target);
    }
    int ways(int idx, int sum, int[] nums, int target){
        if(idx < 0){
            return sum == target ? 1 : 0;
        }
        int withsub = ways(idx-1, sum - (2 * nums[idx]), nums, target);
        int withoutsub = ways(idx-1, sum, nums, target);
        return withsub + withoutsub;
    }
}