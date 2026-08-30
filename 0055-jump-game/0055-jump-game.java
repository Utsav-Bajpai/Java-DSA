class Solution {
    public boolean canJump(int[] nums) {
        int mIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > mIdx) return false;
            mIdx = Math.max(mIdx, nums[i] + i);
        }
        return true;
    }
}