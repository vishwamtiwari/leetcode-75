class SmallestInfiniteSet {
    int currentSmallest = 1;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    Set<Integer> addedBack = new HashSet<>();

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        if (!queue.isEmpty()) {
            int popped = queue.poll();
            addedBack.remove(popped);
            return popped;
        }

        int popped = currentSmallest;
        currentSmallest++;
        return popped;
    }

    public void addBack(int num) {
        if (num < currentSmallest && !addedBack.contains(num)) {
            queue.offer(num);
            addedBack.add(num);
        }
    }
}