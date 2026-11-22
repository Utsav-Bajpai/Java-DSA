class Solution {
    public boolean checkString(String s) {
        boolean set = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'b'){
                set = true;
            }else{
                if(set) return false;
            }
        }
        return true;
    }
}