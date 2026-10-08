class Solution {
    // public int cherryPickup(int[][] grid) {
    //     int n = grid[0].length;
    //     int[][][] dp = new int[grid.length][n][n];
    //     for (int i = 0; i < dp.length; i++) {
    //         for (int j = 0; j < dp[i].length; j++) {
    //             Arrays.fill(dp[i][j], -1);
    //         }
    //     }
    //     return findcherry(0, 0, n - 1, grid, dp);
    // }
    // int findcherry(int row, int col1,int col2, int[][]grid, int[][][] dp){
    //     if(col1 < 0 || col1 > grid[0].length - 1 || col2 < 0 || col2 > grid[0].length - 1) return Integer.MIN_VALUE;
    //     if(row == grid.length - 1){
    //         if(col1 == col2) return grid[row][col1];
    //         return grid[row][col1] + grid[row][col2];
    //     }
    //     if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
    //     int cherry = 0;
    //     if(col1 == col2) cherry = grid[row][col1];
    //     else cherry = grid[row][col1] + grid[row][col2];
    //     int max = Integer.MIN_VALUE;
    //     for(int a = -1; a <= 1; a++){
    //         for(int b = -1; b <= 1; b++){
    //             max = Math.max(max, findcherry(row + 1, col1 + a, col2 + b, grid, dp));
    //         }
    //     }
    //     dp[row][col1][col2] = cherry + max;
    //     return dp[row][col1][col2];
    // }


    // public int cherryPickup(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][][] dp = new int[grid.length][n][n];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if(i == j) dp[m - 1][i][j] = grid[m-1][i];
    //             else dp[m - 1][i][j] = grid[m-1][i] + grid[m-1][j];
    //         }
    //     }
    //     return findcherry(grid, dp);
    // }
    // int findcherry(int[][]grid, int[][][] dp){
    //     for(int  row = grid.length - 2; row >= 0; row--){
    //         for(int col1 = 0; col1 <  grid[0].length; col1++){
    //             for(int col2 = 0; col2 <  grid[0].length; col2++){
    //                 int cherry = 0;
    //                 if(col1 == col2) cherry = grid[row][col1];
    //                 else cherry = grid[row][col1] + grid[row][col2];
    //                 int max = Integer.MIN_VALUE;
    //                 for(int a = -1; a <= 1; a++){
    //                     for(int b = -1; b <= 1; b++){
    //                         int newcol1 = col1 + a;
    //                         int newcol2 = col2 + b;
    //                         if(newcol1 >= 0 && newcol1 < grid[0].length && newcol2 >= 0 && newcol2 < grid[0].length)
    //                         max = Math.max(max, dp[row+1][newcol1][newcol2]);
    //                     }
    //                 }
    //                 dp[row][col1][col2] = cherry + max;
    //             }
    //         }
    //     }
    //     return dp[0][0][grid[0].length - 1];
    // }
    
    
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) dp[i][j] = grid[m-1][i];
                else dp[i][j] = grid[m-1][i] + grid[m-1][j];
            }
        }
        return findcherry(grid, dp);
    }
    int findcherry(int[][]grid, int[][] dp){
        for(int  row = grid.length - 2; row >= 0; row--){
            int[][] curr = new int[grid[0].length][grid[0].length];
            for(int col1 = 0; col1 <  grid[0].length; col1++){
                for(int col2 = 0; col2 <  grid[0].length; col2++){
                    int cherry = 0;
                    if(col1 == col2) cherry = grid[row][col1];
                    else cherry = grid[row][col1] + grid[row][col2];
                    int max = Integer.MIN_VALUE;
                    for(int a = -1; a <= 1; a++){
                        for(int b = -1; b <= 1; b++){
                            int newcol1 = col1 + a;
                            int newcol2 = col2 + b;
                            if(newcol1 >= 0 && newcol1 < grid[0].length && newcol2 >= 0 && newcol2 < grid[0].length)
                            max = Math.max(max, dp[newcol1][newcol2]);
                        }
                    }
                    curr[col1][col2] = cherry + max;
                }
            }
            dp = curr;
        }
        return dp[0][grid[0].length - 1];
    }
}