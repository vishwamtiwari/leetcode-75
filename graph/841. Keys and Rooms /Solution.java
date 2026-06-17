class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Deque<Integer> stack = new ArrayDeque<>();
        int visitedCount = 0;
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            if (visited[currentRoom] == true) {
                continue;
            }

            visited[currentRoom] = true;
            visitedCount++;
            if (visitedCount == rooms.size()) {
                return true;
            }

            for (int key: rooms.get(currentRoom)) {
                if (!visited[key]) {
                    stack.push(key);
                }
            }
        }
        return visitedCount == rooms.size();
    }
}