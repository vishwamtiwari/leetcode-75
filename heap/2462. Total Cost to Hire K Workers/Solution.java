class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();
        long totalCost = 0;
        if (2 * candidates >= costs.length) {
            for (int cost: costs) {
                minHeap1.offer(cost);
            }
            for (int i = 0; i < k; i++) {
                totalCost += minHeap1.poll();
            }
        } else {
            int leftPointer = 0;
            int rightPointer = costs.length - 1;
            while (minHeap1.size() < candidates && leftPointer < rightPointer) {
                minHeap1.offer(costs[leftPointer]);
                leftPointer += 1;
            }
            while (minHeap2.size() < candidates && rightPointer > leftPointer) {
                minHeap2.offer(costs[rightPointer]);
                rightPointer--;
            }

            for (int i = 0; i < k; i++) {
                int min1 = minHeap1.isEmpty() ? Integer.MAX_VALUE : minHeap1.peek();
                int min2 = minHeap2.isEmpty() ? Integer.MAX_VALUE : minHeap2.peek();

                int currentMin = 0;
                if (min1 <= min2) {
                    currentMin = minHeap1.poll();
                    if (leftPointer <= rightPointer) {
                        minHeap1.offer(costs[leftPointer]);
                        leftPointer++;
                    }
                } else {
                    currentMin = minHeap2.poll();
                    if (leftPointer <= rightPointer) {
                        minHeap2.offer(costs[rightPointer]);
                        rightPointer--;
                    }
                }
                totalCost += currentMin;
            }
        }

        return totalCost;
    }
}