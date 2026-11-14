class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minsum = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            int sum = 0;
            for(int a = 0; a < i; a++){
                sum += nums.get(a);
            }
            if(sum > 0){
                minsum = Math.min(sum, minsum);
            }
            for(int j = i; j < nums.size(); j++){
                sum += nums.get(j) - nums.get(j - i);
                if(sum > 0){
                    minsum = Math.min(sum, minsum);
                }
            }
        }
        return minsum == Integer.MAX_VALUE ? -1 : minsum;
    }
}