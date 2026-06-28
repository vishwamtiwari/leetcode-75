class Solution {
    public void dfs(int[][] isConnected, boolean[] visited, int j) {
        visited[j] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false && isConnected[j][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length+1];

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }
}