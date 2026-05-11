class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = nums.length-1; i >= 0; i--){
            while(nums[i] != 0){
                al.add(nums[i] % 10);
                nums[i] /= 10;
            }
        }
        int[] answer = new int[al.size()];
        for(int i = answer.length-1; i >= 0; i--){
            answer[i] = al.get((answer.length-1) - i);
        }
        return answer;
    }
}