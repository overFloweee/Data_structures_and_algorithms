class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    // 这题相较之前的回溯，更难一点
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int index) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; ++i) {
            if (i > index && contains(nums, nums[i], index, i)) {
                continue;
            }
            if (!path.isEmpty() && path.peekLast() > nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

    private boolean contains(int[] array, int value, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
