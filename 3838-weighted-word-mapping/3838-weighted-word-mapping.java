class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        List<Character> al = new ArrayList<>();
        for(char i = 'z'; i >= 'a'; i--){
            al.add(i);
        }
        StringBuffer s = new StringBuffer();
        for(String i : words){
            int mod = 0, sum = 0;
            for(char j : i.toCharArray()){
                sum += weights[j - 'a'];
            }
            mod = sum % 26;
            s = s.append(al.get(mod));
        }
        return s.toString();
    }
}