class Solution {
    public int maxProduct(int[] nums) {
        int leftmax = 1;
        int rightmax = 1;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(leftmax == 0) leftmax = 1;
            if(rightmax == 0) rightmax = 1;
            leftmax = leftmax * nums[i];
            rightmax = rightmax * nums[nums.length-1-i];
            max = Math.max(max, Math.max(leftmax, rightmax));
            
        }
        return max;
    }
}