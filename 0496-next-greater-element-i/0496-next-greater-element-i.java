class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            Stack<Integer> stk = new Stack<>();
            for(int j = nums2.length-1; j >= 0; j--){
                while(!stk.isEmpty() && stk.peek() <= nums2[j]){
                    stk.pop();
                }
                if(stk.isEmpty()) arr[i] = -1;
                else arr[i] = stk.peek();
                stk.push(nums2[j]);
                if(nums1[i] == nums2[j]) break;
            }
        }
        return arr;
    }
}