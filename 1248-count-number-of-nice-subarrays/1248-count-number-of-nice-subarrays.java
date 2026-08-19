class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if(k < 0) return 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0) nums[i] = 1;
            else nums[i] = 0;
        }
        return fG(nums, k) - fG(nums,k-1);
        
    }
    int fG(int[] nums, int k){
        int i = 0, j = 0, sum = 0, count = 0;
        while(j < nums.length){
            sum += nums[j];
            while(sum > k){
                sum -= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}