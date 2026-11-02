class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }else if(nums[i] > nums[j] && dp[j] + 1 == dp[i]) cnt[i] += cnt[j];
            }
            max = Math.max(max, dp[i]);
        }
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] == max) num += cnt[i];
        }
        return num;
    }
}