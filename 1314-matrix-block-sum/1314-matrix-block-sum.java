class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Build the 2D prefix sum matrix (size m+1 x n+1 for easier boundary handling)
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 2. Define coordinates for the block (clamped to matrix boundaries)
                // Use 1-based indexing for the prefix sum array
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m, i + k + 1);
                int c2 = Math.min(n, j + k + 1);
                
                // 3. Apply the 2D range sum formula
                ans[i][j] = pref[r2][c2] - pref[r1][c2] - pref[r2][c1] + pref[r1][c1];
            }
        }
        
        return ans;
    }
}