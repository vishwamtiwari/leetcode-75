class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            // 1. Insert your conditional logic here to update 'flips'
            if (bitC == 1) {
                if ((bitA | bitB) == 0) flips++;
            } else {
                flips += (bitA + bitB);
            }
            // 2. Shift right by 1 to discard the bit we just processed
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }
}