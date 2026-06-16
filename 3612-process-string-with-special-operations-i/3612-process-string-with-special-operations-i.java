class Solution {
    public String processStr(String s) {
        StringBuffer bs = new StringBuffer();
        for(char i : s.toCharArray()){
            if(i == '*'){
                if(bs.length() > 0) bs.deleteCharAt(bs.length()-1);
            }
            else if(i == '#') bs.append(bs);
            else if(i == '%') bs.reverse();
            else bs.append(i);
        }
        return bs.toString();
    }
}