class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int len = flowerbed.length;
        int flowers = 0;

        for (int i = 0; i < len; i++) {
            int current = flowerbed[i];

            if (current == 0 &&
                    (i == 0 || flowerbed[i-1] == 0) &&
                    (i == len-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                flowers++;
            }

            if (flowers >= n) return true;
        }
        return false;
    }
}