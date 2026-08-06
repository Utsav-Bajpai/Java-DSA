class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1) return;
        if(k > nums.length) k = k % nums.length;
        rev(nums, 0, nums.length-1);
        rev(nums, 0, k-1);
        rev(nums, k, nums.length-1);

    }
    void rev(int[] nums, int i, int j){
        
        while(i < j){   
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}