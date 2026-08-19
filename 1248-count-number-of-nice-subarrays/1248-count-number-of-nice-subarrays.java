class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0) nums[i] = 1;
            else nums[i] = 0;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0, count = 0;
        for(int num : nums){
            sum += num;
            if(hm.containsKey(sum - k)) count += hm.get(sum-k);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}