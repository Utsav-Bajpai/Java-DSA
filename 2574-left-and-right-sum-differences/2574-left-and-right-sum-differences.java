class Solution {
    public int[] leftRightDifference(int[] nums) {
        if(nums.length <= 1) return new int[]{0};
        int[] leftsum = new int[nums.length];
        leftsum[0] = 0;
        int[] rightsum = new int[nums.length];
        rightsum[nums.length-1] = 0;
        int[] answer = new int[nums.length];
        int lsum = 0, rsum = 0;
        for(int i = 1; i < nums.length; i++){
            lsum += nums[i-1];
            leftsum[i] = lsum;
            rsum += nums[nums.length-i];
            rightsum[nums.length-1-i] = rsum;
        }
        for(int i = 0; i < nums.length; i++){
            answer[i] = Math.abs(leftsum[i]-rightsum[i]);
        }
        return answer;
    }
}