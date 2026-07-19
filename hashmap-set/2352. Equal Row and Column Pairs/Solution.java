class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int pairsCount = 0;

        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<int[]> rowList = new ArrayList<>();
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                col.add(grid[j][i]);
            }
            if (rowMap.containsKey(col)) {
                pairsCount += rowMap.get(col);
            }
        }
        return pairsCount;
    }
}