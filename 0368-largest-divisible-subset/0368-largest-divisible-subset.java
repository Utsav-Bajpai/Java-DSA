class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        int last = 0;
        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                last = i;
            }
        }
        List<Integer> arr = new ArrayList<>();
        while(hash[last] != last){
            arr.add(nums[last]);
            last = hash[last];
        }
        arr.add(nums[last]);
        return arr;
    }
}