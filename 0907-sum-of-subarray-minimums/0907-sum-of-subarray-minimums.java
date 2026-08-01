class Solution {
    int num = (int)1000000007;
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[] psse = findpsse(arr);
        int[] nse = findnse(arr);
        for(int i = 0; i < arr.length; i++){
            int left = i - psse[i];
            int right = nse[i] - i;
            sum = (sum + (((long)left * right * arr[i]) % num)) % num;
        }
        return (int)sum;
    }
    int[] findnse(int[] arr){
        int[] nums = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }
            nums[i] = stk.isEmpty() ? arr.length : stk.peek();
            stk.push(i);
        }
        return nums;
    }
    int[] findpsse(int[] arr){
        int[] nums = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                stk.pop();
            }
            nums[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        return nums;
    }
}