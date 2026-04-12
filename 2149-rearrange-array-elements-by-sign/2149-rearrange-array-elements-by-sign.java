class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];
        int a=0, b=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                pos[a] = nums[i];
                a++;
            }else{
                neg[b] = nums[i];
                b++;
            }
        }
        a = 0;
        b = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = pos[a];
                a++;
            }else{
                nums[i] = neg[b];
                b++;
            }
        }
        return nums;
    }
}