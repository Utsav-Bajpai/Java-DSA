class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return path(0, 0, obstacleGrid);
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }else if(j+1 < n){
                    dp[j] = dp[j] + dp[j+1];
                }
            }
        }
        return dp[0];
    }

}


    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     // return path(0, 0, obstacleGrid);
    //     for(int i = 0; i < obstacleGrid.length; i++){
    //         for(int j = 0; j < obstacleGrid[0].length; j++){
    //             if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
    //         }
    //     }
    //     return path(obstacleGrid);
    // }


    //memoization
    // int path(int i, int j, int[][] obstacleGrid){
    //     if(i >= obstacleGrid.length || j >= obstacleGrid[0].length ) return 0;
    //     if(obstacleGrid[i][j] == 1) return 0;
    //     if(obstacleGrid[i][j] != 0) return obstacleGrid[i][j];
    //     if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) return 1;
    //     int down = path(i+1, j, obstacleGrid);
    //     int right  = path(i, j + 1, obstacleGrid);
    //     obstacleGrid[i][j] = down + right;
    //     return obstacleGrid[i][j];
    // }

    //tabulation
//     int path(int[][] obstacleGrid){
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         for(int i = m-1; i >= 0; i--){
//             for(int j = n-1; j >= 0; j--){
//                 if(obstacleGrid[i][j] == -1){
//                     obstacleGrid[i][j] = 0;
//                     continue;
//                 }
//                 if(i == m-1 && j == n - 1){
//                     obstacleGrid[i][j] = 1;
//                     continue;
//                 }
//                 int up = 0, right = 0;
//                 if(j+1 < n) up = obstacleGrid[i][j+1];
//                 if(i+1 < m) right = obstacleGrid[i+1][j];
//                 obstacleGrid[i][j] = up + right;
//             }
//         }
//         return obstacleGrid[0][0];
//     }

// }
        