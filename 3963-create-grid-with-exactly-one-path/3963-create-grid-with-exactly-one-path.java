
class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '#');
            grid[i] = new String(row);
        }

        // Create a path along the top row
        char[] firstRow = grid[0].toCharArray();
        Arrays.fill(firstRow, '.');
        grid[0] = new String(firstRow);

        // Create a path down the last column
        for (int i = 1; i < m; i++) {
            char[] row = grid[i].toCharArray();
            row[n - 1] = '.';
            grid[i] = new String(row);
        }

        return grid;
    }
}
