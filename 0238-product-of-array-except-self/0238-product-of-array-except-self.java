class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];
        int n = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(i == 0) prefix[i] = 1;
            else prefix[i] = prefix[i-1] * nums[i-1];
            if(n-i == n) suffix[n] = 1;
            else suffix[n-i] = suffix[n-i+1] * nums[n-i+1];
        }
        for(int i = 0; i < nums.length; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }
}