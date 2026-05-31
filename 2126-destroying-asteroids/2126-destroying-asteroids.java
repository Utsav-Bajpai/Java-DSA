class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long currmass = mass;
        Arrays.sort(asteroids);
        for(int i  = 0; i < asteroids.length; i++){
            if(asteroids[i] <= currmass){
                currmass += asteroids[i];
            }
            else return false;
        }
        return true;
    }
}