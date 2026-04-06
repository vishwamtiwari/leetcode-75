class SOlution {
    public int maxVowels(String s, int k) {
        int initialCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) initialCount++;
        }
        if (initialCount == k) return initialCount;

        int finalCount = initialCount;
        for (int j = k; j < s.length(); j++) {
            if (isVowel(s.charAt(j))) initialCount++;
            if (isVowel(s.charAt(j - k))) initialCount--;
            if (finalCount < initialCount) finalCount = initialCount;
        }

        return finalCount;
    }

    public boolean isVowel(char c) {
        if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u') return true;

        return false;
    }
}