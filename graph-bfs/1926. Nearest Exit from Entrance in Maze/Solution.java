class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        int r = entrance[0];
        int c = entrance[1];
        queue.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int nextRow = current[0] + dir[0];
                int nextCol = current[1] + dir[1];
                int currentSteps = current[2] + 1;

                if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length) {
                    if (maze[nextRow][nextCol] == '.' && !visited[nextRow][nextCol]) {
                        if (nextRow == 0 || nextRow == maze.length - 1 || nextCol == 0 || nextCol == maze[0].length - 1) {
                            if (nextRow != r || nextCol != c) {
                                return currentSteps;
                            }
                        }

                        queue.add(new int[]{nextRow, nextCol, currentSteps});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return -1;
    }
}