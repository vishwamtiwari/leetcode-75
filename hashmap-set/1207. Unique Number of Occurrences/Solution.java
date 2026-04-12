class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num: arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> freq = new HashSet<>();
        for (int num: freqMap.values()) {
            freq.add(num);
        }

        if (freq.size() == freqMap.size()) return true;
        return false;
    }
}