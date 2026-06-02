class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                HashSet<Integer> hs = new HashSet<>();
                for( int k = j+1; k < nums.length; k++){
                    List<Integer> temp = new ArrayList<>();
                    long sum  = nums[i] + nums[j];
                    sum += nums[k];
                    long l = (long)target-sum;
                    if (l >= Integer.MIN_VALUE &&
                        l <= Integer.MAX_VALUE &&
                        hs.contains((int) l)) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)l);
                        Collections.sort(temp);
                        if(!ans.contains(temp)) ans.add(temp);
                    }else{
                        hs.add(nums[k]);
                    }
                }
            }
        }
        return ans;
    }
}