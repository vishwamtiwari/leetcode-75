class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {

        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];

            adj.get(u).add(new int[]{v, 1});
            adj.get(v).add(new int[]{u, 0});
        }

        dfs(0, -1, adj);
        return count;
    }

    public void dfs(int u, int parent, HashMap<Integer, List<int[]>> adj) {
        for (int[] pairs: adj.get(u)) {
            int v = pairs[0];
            int check = pairs[1];

            if (v != parent) {
                if (check == 1) {
                    count++;
                }
                dfs(v, u, adj);
            }
        }
    }
}