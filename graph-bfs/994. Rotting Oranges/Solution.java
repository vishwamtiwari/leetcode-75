class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new ArrayDeque<>();
        int countFresh = 0;
        int currentMinutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j, currentMinutes});
                else if (grid[i][j] == 1) countFresh++;
            }
        }

        if (countFresh == 0) return 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] dir: directions) {
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];

                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                    if (grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        countFresh--;
                        currentMinutes = current[2] + 1;
                        queue.offer(new int[]{nextRow, nextCol, currentMinutes});
                    }
                }
            }
        }

        if (countFresh > 0) return -1;
        return currentMinutes;
    }
}