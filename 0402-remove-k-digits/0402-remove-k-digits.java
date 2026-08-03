class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(!stk.isEmpty() && num.charAt(i) - '0' < stk.peek() - '0' && k > 0){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }
        while(k > 0){
            stk.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        ans.reverse();
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0'){
            i++;
        }

        String res = ans.substring(i);

        return res.length() == 0 ? "0" : res;
    }
}