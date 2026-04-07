class Solution {
    public int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        sumLeft[0] = 0;
        sumRight[0] = 0;

        for (int i = 1; i < sumLeft.length; i++) {
            if (i < sumLeft.length) sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
        }
        for (int j = sumRight.length - 2; j >= 0; j--) {
            if (j >= 0) sumRight[j] = sumRight[j + 1] + nums[j + 1];
        }
        for (int k = 0; k < sumLeft.length; k++) {
            if (sumLeft[k] == sumRight[k]) return k;
        }
        return -1;
    }
}