// class Solution {
//     public int minDistance(String word1, String word2) {
//         int[][] dp = new int[word1.length()+1][word2.length()+1];
//         for(int[] i : dp){
//             Arrays.fill(i, -1);
//         }
//         return findsteps(word1.length(), word2.length(), word1, word2, dp);
//     }
//     int findsteps(int i, int j, String word1, String word2, int[][] dp){
//         if(i == 0) return j;
//         if(j == 0) return i;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(word1.charAt(i - 1) == word2.charAt(j - 1)){
//             dp[i][j] =  0 + findsteps(i-1, j-1, word1, word2, dp);
//         }else{
//             dp[i][j] = Math.min(1 + findsteps(i, j-1, word1, word2, dp), Math.min(1 + findsteps(i-1, j, word1, word2, dp), 1 + findsteps(i-1, j-1, word1, word2, dp)));
//         }
//         return dp[i][j];
//     }
// }

// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         int[][] dp = new int[word1.length()+1][word2.length()+1];
//         for(int i = 0; i <= n; i++){
//             dp[i][0] = i;
//         }
//         for(int j = 0; j <= m; j++){
//             dp[0][j] = j;
//         }
//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= m; j++){
//                 if(word1.charAt(i - 1) == word2.charAt(j - 1)){
//                     dp[i][j] =  0 + dp[i-1][j-1];
//                 }else{
//                     dp[i][j] = Math.min(1 + dp[i-1][j], Math.min(1 + dp[i][j-1], 1 + dp[i-1][j-1]));
//                 } 
//             }
//         }
//         return dp[n][m];
//     }
// }
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] curr = new int[m + 1];
        int[] prev = new int[m + 1];
        
        for(int j = 0; j <= m; j++){
            prev[j] = j;
        }
        for(int i = 1; i <= n; i++){
            curr[0] = i;
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    curr[j] =  0 + prev[j-1];
                }else{
                    curr[j] = 1 + Math.min(prev[j], Math.min(curr[j-1],prev[j-1]));
                } 
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[m];
    }
}