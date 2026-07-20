class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

          for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp.add(grid[i][j]);
            }
        }

        int total = temp.size();
        k %= total; 
          Collections.rotate(temp, k);

        List<List<Integer>> ans = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(temp.get(idx++));
            }
            ans.add(row);
        }

        return ans;
    }
}