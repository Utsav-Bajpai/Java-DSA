class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hm = new HashSet<>();
        for(int num : nums){
            hm.add(num);
        }
        int n = 0;
        for(int num : hm){
            if(!hm.contains(num-1)){
                int count = 1;
                int cnum = num;
                while(hm.contains(cnum+1)){
                    count++;
                    cnum++;
                }
                n = Math.max(n, count);
            }
        }
        return  n;
    }
}