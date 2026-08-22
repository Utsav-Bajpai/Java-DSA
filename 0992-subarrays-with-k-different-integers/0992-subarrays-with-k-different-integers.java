class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return nSA(nums, k) - nSA(nums, k-1);
    }
    int nSA(int[] nums, int k){
        int i = 0, j = 0, count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        while(j < nums.length){
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            while(hm.size() > k){
                hm.put(nums[i], hm.get(nums[i]) - 1 );
                if(hm.get(nums[i]) == 0) hm.remove(nums[i]);
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}