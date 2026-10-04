class Solution {
    public int uniquePaths(int m, int n) {
      int[] dp = new int[n];
      for(int i = 0; i < n; i++){
        // Arrays.fill(row, -1); for memoization
        dp[i] = 0;
      }
      return ways(m, n, dp);  
    }
    // int ways(int i, int j, int[][] dp){
        // memoization
        // if(i >= dp.length || j >= dp[0].length){
        //     return 0;
        // }
        // if(i == dp.length - 1 && j == dp[0].length-1) return 1;
        // if(dp[i][j] != -1) return dp[i][j];
        // int down = ways(i + 1, j, dp);
        // int right = ways(i, j + 1, dp);
        // dp[i][j] = down + right;
        // return dp[i][j];
    // }


    // tubulation
    // int ways(int m, int n, int[][] dp){
        
    //     for(int i = m-1; i >= 0; i--){
    //         for(int j = n-1; j >= 0; j--){
    //             if(i == m-1 && j == n-1){
    //                 dp[i][j] = 1;
    //                 continue;
    //             }
    //             int down = 0;
    //             int right = 0;

    //             if(i + 1 < m) down = dp[i + 1][j];
    //             if(j + 1 < n) right = dp[i][j + 1];

    //             dp[i][j] = down + right;
    //         }
    //     }
    //     return dp[0][0];
    // }

    //space optimization
    int ways(int m, int n, int[] dp){
        dp[n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
               if(j + 1 < n)dp[j] = dp[j] + dp[j+1]; 
            }
        }
        return dp[0];
    }
}