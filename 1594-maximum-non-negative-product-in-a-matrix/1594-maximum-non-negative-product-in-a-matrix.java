class Solution {
    public int maxProductPath(int[][] grid) {
        int mod = 1000000007;
        int m = grid.length;
        int n = grid[0].length;

        long[][] maxgt = new long[m][n];
        long[][] minlt = new long[m][n];

        // Base case
        maxgt[0][0] = minlt[0][0] = grid[0][0];

        // First row
        for (int j = 1; j < n; j++) {
            maxgt[0][j] = minlt[0][j] = maxgt[0][j - 1] * grid[0][j];
        }

        // First column
        for (int i = 1; i < m; i++) {
            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];
        }

        // Fill DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                } else {
                    maxgt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                }
            }
        }

        long result = maxgt[m - 1][n - 1];

        if (result < 0) {
            return -1;
        }

        return (int)(result % mod);
    }
}