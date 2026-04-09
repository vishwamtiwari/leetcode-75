class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer num: nums1) {
            set1.add(num);
        }
        for (Integer num: nums2) {
            set2.add(num);
        }

        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();

        for (Integer num: set1) {
            if (!set2.contains(num)) diff1.add(num);
        }
        for (Integer num: set2) {
            if (!set1.contains(num)) diff2.add(num);
        }

        return List.of(diff1, diff2);
    }
}