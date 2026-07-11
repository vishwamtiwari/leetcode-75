class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int len = nums1.length;
        int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        long maxScore = 0;
        long currentSum = 0;
        for (int[] pair: pairs) {
            minHeap.offer(pair[0]);
            currentSum += pair[0];
            if (minHeap.size() > k) {
                currentSum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, currentSum * pair[1]);
            }
        }
        return maxScore;
    }
}