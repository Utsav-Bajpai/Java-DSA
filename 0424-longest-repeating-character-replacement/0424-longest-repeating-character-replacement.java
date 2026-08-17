class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, ml = 0, nc = 0, mf = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            mf = Math.max(mf, map.get(ch));
            if(j - i + 1 - mf > k){
                map.put(s.charAt(i), map.get(s.charAt(i))- 1);
                i++;
            }
            ml = Math.max(j - i + 1, ml);
            j++;
        }
        return ml; 
    }
}