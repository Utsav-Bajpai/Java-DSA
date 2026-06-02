class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if( i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length; j++){
                if(j  != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = nums.length-1;
                while(k < l){
                    List<Integer> temp = new ArrayList<>();
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(target == sum){
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        if(!ans.contains(temp)) ans.add(temp);
                        k++;
                        l--;
                    }
                    else if(target > sum) k++;
                    else l--;
                }
                
            }
        }
        return ans;
    }
}