class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(nums[left] == target){
                return left;
            }else left++;
            if(nums[right] == target){
                return right;
            }else right--;
        }
        return -1;
        
    }
}