class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                dp[i][j] = -1;
            }
        }
        int lpsl = lps(s, 0, s.length()-1, dp);
        return lpsl;
    }
    int lps(String s, int i, int j, int[][] dp){
        if(i >= j) return i == j ? 1 : 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            int len = lps(s, i+1, j-1, dp);
            dp[i][j] = len+2;
            return len+2;
        }else{
            int lenr = lps(s, i+1, j, dp);
            int lenl = lps(s, i, j-1, dp);
            dp[i][j] = Math.max(lenr, lenl);
            return Math.max(lenr, lenl);
        }
    }
}