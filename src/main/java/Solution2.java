import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public static void main(String[] args) {
        new Solution2().findSubsequences(new int[]{1, 2, 1, 1});
    }

    public void backTracking(int[] nums, int index) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
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
