class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            rev(0, n-1, nums);
            return;
        }
        for(int i = n-1; i > idx; i--){
            if(nums[i] > nums[idx]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        rev(idx+1, n-1, nums);
    }
    int[] rev(int i, int n, int[] nums){
        while(i <= n){
            int temp = nums[n];
            nums[n] = nums[i];
            nums[i] = temp;
            i++;
            n--;
        }
        return nums;
    }
}