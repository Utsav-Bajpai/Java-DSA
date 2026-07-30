class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        Map<Integer, Integer> hs = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for(int j = nums2.length-1; j >= 0; j--){
            while(!stk.isEmpty() && stk.peek() <= nums2[j]){
                stk.pop();
            }
            if(stk.isEmpty()) hs.put(nums2[j], -1);
            else hs.put(nums2[j], stk.peek());
            stk.push(nums2[j]);
        }
        int idx = 0;
        for(int i : nums1){
            arr[idx] = hs.get(i);
            idx++;
        }
        return arr;
    }
}