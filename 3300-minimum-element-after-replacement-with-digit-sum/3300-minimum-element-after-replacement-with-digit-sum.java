class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int a = 0;
            while(n != 0){
                a += n%10;
                n /= 10;
            }
            nums[i] = a;
            min = Math.min(min, a);
        }
        return min;
    }
}