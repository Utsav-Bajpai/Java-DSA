class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] arr = new int[nums.length + 1 - k ];
        for(int i = 0; i < nums.length; i++){
            if(!dq.isEmpty() &&dq.peekFirst() <= i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1) arr[i - k + 1] = nums[dq.peekFirst()];
        }
        return arr;
    }
}