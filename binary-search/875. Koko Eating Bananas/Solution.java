class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (finished(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean finished(int[] piles, int speed, int h) {
        long hrs = 0;
        for (int i = 0; i < piles.length; i++) {
            hrs += (piles[i] + speed - 1) / speed;
        }
        return hrs <= h;
    }
}