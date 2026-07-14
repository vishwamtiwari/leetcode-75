class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 0, new ArrayList<>(), result, 1);
        return result;
    }
    public static void backtrack(int k, int n, int sum, List<Integer> current, List<List<Integer>> result, int index) {
        if (current.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(current));
                return;
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            sum += i;
            current.add(i);
            backtrack(k, n, sum, current, result, i + 1);
            sum -= i;
            current.remove(current.size() - 1);
        }
    }
}