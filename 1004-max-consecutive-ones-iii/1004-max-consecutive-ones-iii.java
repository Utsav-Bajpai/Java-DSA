class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, z = 0;
        while(l <= r && r < nums.length){
            if(nums[r] == 0) z++;
            while(z > k){
                if(nums[l] == 0) z--;
                l++;
            }
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
                r++;
        }
        return maxLen;
    }
}