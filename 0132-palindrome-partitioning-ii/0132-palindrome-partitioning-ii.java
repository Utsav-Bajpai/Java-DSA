class Solution {
    // public int minCut(String s) {
    //     int[] dp = new int[s.length()];
    //     Arrays.fill(dp, -1);
    //     return noOfPartitions(0, s, dp) - 1;
    // }
    // int noOfPartitions(int i, String s, int[] dp){
    //     if(i >= s.length()) return 0;
    //     if(dp[i] != -1) return dp[i];
    //     int maxcut = Integer.MAX_VALUE;
    //     for(int j = i; j < s.length(); j++){
    //         String temp = s.substring(i, j + 1);
    //         if(isPalindrome(temp)){
    //             int cut = 1 + noOfPartitions(j + 1, s, dp);
    //             maxcut = Math.min(cut, maxcut);
    //         }
    //     }
    //     return dp[i] = maxcut;
    // }
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        for(int i = s.length()-1; i >= 0; i--){
           int maxcut = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(s, i, j)){
                    int cut = 1 + dp[j+1];
                    maxcut = Math.min(cut, maxcut);
                }
            }
            dp[i] = maxcut;
        }
        return dp[0] - 1;
    }
    boolean isPalindrome(String k, int i, int j){
        if(i == j) return true;
        while(i < j){
            if(k.charAt(i++) != k.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}