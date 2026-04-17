class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int fre = 1;
        for(int i = 1; i<nums.length; i++){
            if(fre == 0){
                fre++;
                majority = nums[i];
            }else if(majority == nums[i]){
                fre++;
            }else{
                fre--;
            }
        }
        return majority;
    }
}