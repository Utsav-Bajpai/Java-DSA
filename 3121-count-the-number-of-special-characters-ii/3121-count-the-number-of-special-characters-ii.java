class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashSet<Character> hs = new HashSet<>();
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c) && !hs.contains(Character.toLowerCase(c))) hs.add(c);
            else if(Character.isLowerCase(c) && hs.contains(Character.toUpperCase(c))) hs.remove(c);
            else{
                if(Character.isLowerCase(c) && !hs.contains(c)) hs.add(c);
                if(Character.isUpperCase(c) && hs.contains(Character.toLowerCase(c)))hs.add(c);
            }
        }
        for(char c = 'a'; c <= 'z'; c++){
            if(hs.contains(c) && hs.contains(Character.toUpperCase(c))) count++;
        }

        return count;
    }
}