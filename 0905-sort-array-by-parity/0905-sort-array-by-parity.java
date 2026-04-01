class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        if(n<=1) return nums;
        int even = 0;
        int odd = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[even]%2!=0 && nums[odd]%2==0){
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even++;
                odd++;
            }else if(nums[even]%2!=0 && nums[odd]%2!=0){
                odd++;
            }else{
                even++;
                odd++;

            }
            if(odd>=n) break;
        }
        return nums;
    }
}