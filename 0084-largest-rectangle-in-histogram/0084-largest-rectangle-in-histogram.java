class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] psei = PSEI(heights);
        int[] nsei = NSEI(heights);
        int ma = 0;
        for(int i = 0; i < heights.length; i++){
            int area = heights[i] * (nsei[i] - psei[i] -1);
            ma = Math.max(area, ma);
        }
        return ma;

    }
    int[] PSEI(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] nums = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }
            nums[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        return nums;
    }
    int[] NSEI(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        int[] nums = new int[n];
        for(int i = arr.length - 1; i >= 0; i--){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }
            nums[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }
        return nums;
    }
}