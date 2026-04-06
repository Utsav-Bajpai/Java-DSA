class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int num = 0;
        int i = 0;
        int sign = 1;
        if(s.length()==0)return 0;
        if(s.charAt(i) == '-'){
                sign = -1;
                i++;
        }else if(s.charAt(i) == '+') i++;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            
            int digit = s.charAt(i) - '0';
            if(num > (Integer.MAX_VALUE - digit) / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}