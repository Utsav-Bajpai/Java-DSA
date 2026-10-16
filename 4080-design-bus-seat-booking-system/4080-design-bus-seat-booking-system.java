class BusBooking {
    private boolean[][] booked;
    private int[][] cost;
    private int totaltime;
    private int bookedcnt;

    public BusBooking(int n) {
        booked = new boolean[n+1][4];
        cost = new int[n+1][4];
        totaltime = 0;
        bookedcnt = 0;
    }
    
    public void toggle(String seat) {
        int col = seat.charAt(0) - 'A';
        int row = Integer.parseInt(seat.substring(1));
        int time = 1;
        if(booked[row][col]){
            totaltime -= cost[row][col];
            booked[row][col] = false;
            bookedcnt--;
            cost[row][col] = 0;
        }else{
            if(col == 0 && booked[row][1]){
                time = 3;
            }
            if(col == 3 && booked[row][2]){
                time = 3;
            }
            totaltime += time;
            bookedcnt++;
            cost[row][col] = time;
            booked[row][col] = true;
        }
    }
    
    public int getTotalTime() {
        return totaltime;
    }
    
    public int getMinTime() {
        return bookedcnt;
        
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */