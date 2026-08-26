class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length()][t2.length()];
        for(int i = 0; i < t1.length(); i++){
            for(int j = 0; j < t2.length(); j++){
                dp[i][j] = -1;
            }
        }
        int lcsl = lcs(t1, 0, t2, 0, dp);
        return lcsl;
    }
    int lcs(String t1, int i, String t2, int j, int[][]dp){
        if(i == t1.length() || j == t2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j)){
            int res = lcs(t1, i+1, t2, j+1, dp);
            dp[i][j] = res+1;
            return res+1;
        }else{
            int lent1 = lcs(t1, i+1, t2, j, dp);
            int lent2 = lcs(t1, i, t2, j+1, dp);
            dp[i][j] = Math.max(lent1, lent2);
            return Math.max(lent1, lent2);
        }
    }
}