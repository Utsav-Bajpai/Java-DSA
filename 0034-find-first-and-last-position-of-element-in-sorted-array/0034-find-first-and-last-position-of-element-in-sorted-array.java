class Solution {
    public int[] searchRange(int[] nums, int target) {
        int  a = 0, b = nums.length-1;
        int[] arr = {-1, -1};
        while(a<=b){
            if(nums[a] == target && nums[b] == target) return new int[]{a, b};
            else if(nums[a] != target && nums[b] == target) a++;
            else b--;
        }
        return arr;
    }
}