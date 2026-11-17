// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         Boolean[][] dp = new Boolean[n + 1][m + 1];
//         return ispossible(n, m, s, p, dp);
//     }
//     boolean ispossible(int i, int j, String s, String p, Boolean dp[][]){
//         if(i == 0 && j == 0) return true;
//         if(j == 0) return false;
//         if(i == 0) {
//             for(int k = 1; k <= j; k++) {
//                 if(p.charAt(k - 1) != '*') return false;
//             }
//             return true;
//         }
//         if(dp[i][j] != null) return dp[i][j];
//         if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') return dp[i][j] = ispossible(i-1, j-1, s, p, dp);
//         if(p.charAt(j - 1) == '*') return dp[i][j] = ispossible(i-1, j, s, p, dp) || ispossible(i, j-1, s, p, dp);
//         dp[i][j] = false;
//         return dp[i][j];
//     }
// }

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];
        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            prev[j] = prev[j - 1] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= n; i++) {
            curr[0] = false;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) ||
                    p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}