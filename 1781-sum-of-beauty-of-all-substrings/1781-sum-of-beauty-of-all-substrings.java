class Solution {
    public int beautySum(String s) {
        if(s.length() == 1) return 0;
        int ans = 0;
        for( int j = 0; j < s.length(); j++){
            int[] arr = new int[26];
            for(int i = j; i < s.length(); i++){
                arr[s.charAt(i) - 'a']++;
                int max = 0, min = Integer.MAX_VALUE;
                for(int k : arr){
                    if(k > 0){
                        max = Math.max(max, k);
                        min = Math.min(min, k);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}