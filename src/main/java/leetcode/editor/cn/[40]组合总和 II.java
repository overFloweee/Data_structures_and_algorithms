class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int index, int sum) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length && sum + candidates[i] <= target; ++i) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int num = candidates[i];
            sum += num;
            path.add(num);
            backTracking(candidates, target, i + 1, sum);
            path.removeLast();
            sum -= num;
        }
    }
}
