class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        backtrack(0, n, board, col, d1, d2);
        return res;
    }
    void backtrack(int r, int n, char[][] board, boolean[] col, boolean[] d1, boolean[] d2) {
        if (r == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : board) temp.add(new String(row));
            res.add(temp);
            return;
        }
        for (int c = 0; c < n; c++) {
            int id1 = r - c + n;
            int id2 = r + c;
            if (col[c] || d1[id1] || d2[id2]) continue;
            board[r][c] = 'Q';
            col[c] = d1[id1] = d2[id2] = true;
            backtrack(r + 1, n, board, col, d1, d2);
            board[r][c] = '.';
            col[c] = d1[id1] = d2[id2] = false;
        }
    }
}