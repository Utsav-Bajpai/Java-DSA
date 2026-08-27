class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0, prod = 1, num = 0;
        while(j < nums.length){
            prod *= nums[j++];
            while(prod >= k && i < nums.length) prod /= nums[i++];
            num += j - i;
        }
        return num;
        
    }
}