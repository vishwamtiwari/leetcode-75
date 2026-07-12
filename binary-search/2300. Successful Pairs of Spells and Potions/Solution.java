class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int spellLen = spells.length;
        int[] res = new int[spellLen];

        for (int i = 0; i < spellLen; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) / 2);
                long currentProd = (long) spells[i] * potions[mid];
                if (currentProd >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }
}