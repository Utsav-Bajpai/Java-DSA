class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int len = lps(s, rev);
        return s.length() - len;
    }
    int lps(String s, String rev){
        int dp[][] = new int[s.length() + 1][rev.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= rev.length(); j++){
                if(s.charAt(i - 1) == rev.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][rev.length()];
    }
}