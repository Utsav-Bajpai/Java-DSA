class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lowerbound = 0;
        int upperbound = 0;

        // Step 1: Find bounds
        for (int w : weights) {
            lowerbound = Math.max(lowerbound, w);
            upperbound += w;
        }

        // Step 2: Binary Search
        while (lowerbound < upperbound) {
            int mid = lowerbound + (upperbound - lowerbound) / 2;

            if (canShip(weights, days, mid)) {
                upperbound = mid;
            } else {
                lowerbound = mid + 1;
            }
        }

        return lowerbound;
    }

    // Helper function
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {
            if (currentWeight + w > capacity) {
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += w;
        }

        return requiredDays <= days;
    }
}