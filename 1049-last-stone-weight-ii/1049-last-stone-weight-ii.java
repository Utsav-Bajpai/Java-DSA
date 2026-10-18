class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0; i < stones.length; i++){
            sum += stones[i];
        }
        boolean[][] dp = new boolean[stones.length][sum + 1];
        for(int i = 0; i < stones.length; i++){
            dp[i][0] = true;
        }
        if(stones[0] <= sum) dp[0][stones[0]] = true;
        for(int idx = 1; idx < stones.length; idx++){
            for(int col = 1; col <= sum; col++){
                boolean nottake = dp[idx - 1][col];
                boolean take = false;
                if(stones[idx] <= col){
                    take = dp[idx - 1][col - stones[idx]];
                }
                dp[idx][col] = take || nottake;
            }
        }
        for(int i = sum/2; i >= 0 ; i--){
            if(dp[stones.length - 1][i]){
                return sum - 2 * i;
            }
        }
        return 0;
    }
}