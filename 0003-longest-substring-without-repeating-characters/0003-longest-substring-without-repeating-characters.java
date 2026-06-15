class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> str = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            while(str.contains(s.charAt(right))){
                str.remove(s.charAt(left));
                left++;
            }
            str.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}