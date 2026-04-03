class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int len = 0;
        boolean oddFound = false;

        for (int count : freq) {
            if (count % 2 == 0) {
                len += count;
            } else {
                len += count - 1;
                oddFound = true;
            }
        }

        if (oddFound) len += 1;

        return len;
    }
}