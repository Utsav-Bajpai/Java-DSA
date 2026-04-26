class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length-2; i++){
            int pt1 = i,pt3 = nums.length-1, pt2 = i+1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(pt2 < pt3){
                int sum = nums[pt1] + nums[pt2] + nums[pt3];
                if(sum > 0){
                    pt3--;
                }else if (sum < 0){
                    pt2++;
                }else{
                    ans.add(Arrays.asList(nums[pt1],nums[pt2],nums[pt3]));
                    while(pt2 < pt3 && nums[pt2] == nums[pt2+1]) pt2++;
                    while(pt2 < pt3 && nums[pt3] == nums[pt3-1]) pt3--;
                    pt2++;
                    pt3--;
                }
            }
        }
        return ans;
    }
}