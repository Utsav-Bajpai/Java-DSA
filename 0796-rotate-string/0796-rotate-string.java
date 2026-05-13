class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i = 0; i < s.length(); i++){
            if(s.equals(goal)) return true;
            else{
                char a = s.charAt(0);
                s = s.substring(1)+a;
            }
        }
        return false;
    }
}