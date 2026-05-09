class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int balance = 0;
        for(char a : s.toCharArray()){
            if(a == '('){
                if(balance > 0) ans.append(a);
                balance++;
            }else{
                balance--;
                if(balance > 0) ans.append(a);
                
            }
        }
        return ans.toString();
    }
}