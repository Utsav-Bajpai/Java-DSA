class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        for(int i = prices.length - 1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                for(int c = 1; c <= k; c++){
                    if(j == 1){
                        curr[j][c] = Math.max(-prices[i] + after[0][c], after[1][c]);
                    }else{
                        curr[j][c] = Math.max(prices[i] + after[1][c - 1], after[0][c]);
                    }
                }
            }
            int[][] temp = after;
            after = curr;
            curr = temp;
        }
        return after[1][k];
    }
}